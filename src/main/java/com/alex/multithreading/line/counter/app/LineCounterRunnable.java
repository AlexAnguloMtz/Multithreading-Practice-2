package com.alex.multithreading.line.counter.app;

import com.alex.multithreading.chronometer.Chronometer;
import com.alex.multithreading.counter.Counter;
import com.alex.multithreading.files.FileLineCounter;

import java.util.function.Consumer;

import static java.lang.Thread.currentThread;

/**
 * Runnable implementation to perform all the required operations with a single file.
 * Each object of this class will run in a new Thread.
 *
 * @author Alex Angulo
 */
public class LineCounterRunnable implements Runnable {
    private final String fileName;
    private final Counter counter;
    private final Consumer<LineCountingResults> resultsConsumer;
    private final Chronometer chronometer;
    private final FileLineCounter lineCounter;

    public LineCounterRunnable(String fileName,
                               Counter counter,
                               Consumer<LineCountingResults> resultsConsumer) {
        this.fileName = fileName;
        this.counter = counter;
        this.resultsConsumer = resultsConsumer;
        this.chronometer = new Chronometer();
        this.lineCounter = new FileLineCounter();
    }

    /**
     * 1) Display the name of the current Thread
     * 2) Display the name of the file handled by this Runnable
     * 3) Display the number of lines in said file
     * 4) Display the total time spent in this operation
     *
     */
    @Override
    public void run() {
        long timePassed = chronometer.measureTime( () -> countLines() );
        sendToConsumer(resultsWith(timePassed));
    }

    private void countLines() {
        lineCounter.countLinesInFile(fileName, counter);
    }

    private LineCountingResults resultsWith(long time) {
        return new LineCountingResults(threadName(), fileName, numberOfLines(), time);
    }

    private long numberOfLines() {
        return counter.get();
    }

    private String threadName() {
        return currentThread().getName();
    }

    private void sendToConsumer(LineCountingResults results) {
        resultsConsumer.accept(results);
    }

}
