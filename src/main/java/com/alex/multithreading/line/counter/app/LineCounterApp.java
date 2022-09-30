package com.alex.multithreading.line.counter.app;

import com.alex.multithreading.chronometer.Chronometer;
import com.alex.multithreading.counter.Counter;
import com.alex.multithreading.counter.impl.DoubleCounterDecorator;
import com.alex.multithreading.counter.impl.SimpleCounter;

import java.util.function.Consumer;

import static java.util.Arrays.stream;

/**
 *  App to count all the lines in all the files with the provided file names.
 *  Each file will be handled in a new Thread.
 *
 * @author Alex Angulo
 */
public class LineCounterApp {

    private final Counter counterForAllThreads;
    private final CommandLineInterface userInterface;
    private final Chronometer chronometer;

    public LineCounterApp(Counter counterForAllThreads) {
        this.counterForAllThreads = counterForAllThreads;
        this.userInterface = new CommandLineInterface();
        this.chronometer = new Chronometer();
    }

    /**
     * Run the app.
     *
     * For each file name, display the name of the current Thread,
     * display the name of the file, display the number of lines
     * in the provided file and display the time spent in this operation.
     *
     * @param fileNames the file names
     */
    public void runWithFiles(String[] fileNames) {
        long totalTime = chronometer.measureTime( () -> doRun(fileNames) );
        displayTotalTime(totalTime);
    }

    private void doRun(String[] fileNames) {
        stream(fileNames).forEach(fileName -> countLinesInNewThread(fileName));
        displayTotalLineCount();
    }

    private void countLinesInNewThread(String fileName) {
        try {
            doCountLinesInNewThread(fileName);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void doCountLinesInNewThread(String fileName) throws InterruptedException {

        Thread thread = new Thread(runnableForFile(fileName));
        thread.start();

        // We need a join() so we can get the final count of
        // all lines in all files after all threads have finished
        thread.join();

    }

    private Runnable runnableForFile(String fileName) {
        return new LineCounterRunnable(fileName, decoratedCounter(), resultsConsumer());
    }

    private Consumer<LineCountingResults> resultsConsumer() {
        return results -> userInterface.display(results);
    }

    private Counter decoratedCounter() {
        return new DoubleCounterDecorator(new SimpleCounter(), counterForAllThreads);
    }

    private void displayTotalLineCount() {
        userInterface.displayTotalLineCount(totalLineCount());
    }

    private void displayTotalTime(long totalTime) {
        userInterface.displayTotalTime(totalTime);
    }


    private long totalLineCount() {
        return counterForAllThreads.get();
    }


}
