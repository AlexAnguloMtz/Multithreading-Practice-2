package com.alex.multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

import static java.lang.Thread.currentThread;

/**
 *  Runnable implementation that takes the name of one file
 *  and determines the number of lines in it
 *
 * @author Alex Angulo
 */
class LineCounter implements Runnable {

    private static final String COULD_NOT_READ_FILE = "Could not read file: %s";

    private final String filename;
    private final Consumer<LineCountingResults> resultsConsumer;
    private final Counter externalCounter;
    private final Counter ownCounter;
    private final Chronometer chronometer;

    public LineCounter(String filename,
                       Consumer<LineCountingResults> resultsConsumer,
                       Counter externalCounter) {
        this.filename = filename;
        this.resultsConsumer = resultsConsumer;
        this.externalCounter = externalCounter;
        this.ownCounter = new SimpleCounter();
        this.chronometer = new Chronometer();
    }

    /**
     *  Count the number of lines in the file
     *  with the filename injected in the constructor,
     *  measure the time that this operation takes,
     *  and send all the results to the Consumer<LineCountingResults>
     *  injected in the constructor
     *
     */
    @Override
    public void run() {
        Runnable countLinesInFile = () -> countLinesInFile();
        long time = chronometer.measureTime(countLinesInFile);
        LineCountingResults results = resultsWith(time);
        sendToConsumer(results);
    }

    private void countLinesInFile() {
        try (var reader = new BufferedReader(new FileReader(filename))) {
            countLinesWith(reader);
        } catch (Exception exception) {
            throw new RuntimeException(COULD_NOT_READ_FILE);
        }
    }

    private void countLinesWith(BufferedReader reader) throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null) {
            ownCounter.add(1);
            externalCounter.add(1);
        }
    }

    private LineCountingResults resultsWith(long totalTime) {
        return new LineCountingResults(threadName(), filename, numberOfLines(), totalTime);
    }

    private long numberOfLines() {
        return ownCounter.get();
    }

    private void sendToConsumer(LineCountingResults results) {
        resultsConsumer.accept(results);
    }

    private String threadName() {
        return currentThread().getName();
    }

}