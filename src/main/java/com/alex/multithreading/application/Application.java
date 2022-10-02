package com.alex.multithreading.application;

import com.alex.multithreading.chronometer.Chronometer;
import com.alex.multithreading.counter.Counter;
import com.alex.multithreading.counter.impl.DoubleCounterDecorator;
import com.alex.multithreading.counter.impl.SimpleCounter;

import static java.lang.String.format;
import static java.util.Arrays.stream;

public class Application {
    
    private final Counter counterForAllThreads;
    private final Chronometer chronometer;

    public Application(Counter counterForAllThreads) {
        this.counterForAllThreads = counterForAllThreads;
        this.chronometer = new Chronometer();
    }

    public void runWithFiles(String[] fileNames) {
        long timeSpent = chronometer.measureTime( () -> doRun(fileNames) );
        displayTimePassed(timeSpent);
        displayTotalLines();
    }

    private void displayTotalLines() {
        display(totalLinesMessage());
    }

    private void handleFileInNewThread(String fileName) {
        try {
            doHandleFileInNewThread(fileName);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void doHandleFileInNewThread(String fileName) throws InterruptedException {
        Runnable runnable = runnableForFile(fileName);
        Thread thread = new Thread(runnable);
        thread.start();

        // We need to call join() because we are counting all lines in
        // all files in a concurrent way. Therefore, we need to wait
        // for all Threads to finish, so we can display the final result correctly.
        thread.join();
    }

    private Runnable runnableForFile(String fileName) {
        return new ApplicationRunnable(fileName, doubleCounter());
    }

    private Counter doubleCounter() {
        return new DoubleCounterDecorator(new SimpleCounter(), counterForAllThreads);
    }

    private void doRun(String[] fileNames) {
        stream(fileNames).forEach(fileName -> handleFileInNewThread(fileName));
    }

    private void displayTimePassed(long timePassed) {
        display(timePassedMessage(timePassed));
    }

    private String timePassedMessage(long timePassed) {
        return format("Total time passed: %d milliseconds", timePassed);
    }

    private String totalLinesMessage() {
        return format("Total lines in all files: %d", counterForAllThreads.get());
    }

    private void display(String message) {
        System.out.println(message);
    }

}
