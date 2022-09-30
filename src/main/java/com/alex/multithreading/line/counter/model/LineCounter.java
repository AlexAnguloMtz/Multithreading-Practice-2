package com.alex.multithreading.line.counter.model;

import com.alex.multithreading.chronometer.Chronometer;
import com.alex.multithreading.counter.Counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;

/**
 *  Runnable implementation that takes the name of one file,
 *  determines the number of lines in it, the total time spent
 *  in counting these lines and the name of the current Thread.
 *
 * @author Alex Angulo
 */
public class LineCounter implements Runnable {

    private static final String COULD_NOT_READ_FILE = "Could not read file: %s";

    private final String filename;
    private final Consumer<LineCountingResults> resultsConsumer;
    private final Counter counter;
    private final Chronometer chronometer;

    public LineCounter(String filename,
                       Consumer<LineCountingResults> resultsConsumer,
                       Counter counter) {
        this.filename = filename;
        this.resultsConsumer = resultsConsumer;
        this.counter = counter;
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
        long timeSpent = chronometer.measureTime( () -> countLinesInFile(filename) );
        sendToConsumer(resultsWith(timeSpent));
    }

    private void countLinesInFile(String filename) {
        try (var reader = new BufferedReader(new FileReader(filename))) {
            countLinesWith(reader);
        } catch (Exception exception) {
            throw new RuntimeException(format(COULD_NOT_READ_FILE, filename));
        }
    }

    private void countLinesWith(BufferedReader reader) throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null)
            counter.add(1);
    }

    private LineCountingResults resultsWith(long totalTime) {
        return new LineCountingResults(threadName(), filename, numberOfLines(), totalTime);
    }

    private long numberOfLines() {
        return counter.get();
    }

    private void sendToConsumer(LineCountingResults results) {
        resultsConsumer.accept(results);
    }

    private String threadName() {
        return currentThread().getName();
    }

}