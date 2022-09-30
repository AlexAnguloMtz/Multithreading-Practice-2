package com.alex.multithreading;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Arrays.stream;

/**
 *  App to count all the lines in all the files
 *  with the provided file names
 *
 *  @author Alex Angulo
 */
public class LineCounterApp {

    private final Counter counterForAllThreads;
    private final CommandLineInterface userInterface;

    public LineCounterApp(Counter counterForAllThreads) {
        this.counterForAllThreads = counterForAllThreads;
        this.userInterface = new CommandLineInterface();
    }

    public void run(String[] fileNames) {
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

        Runnable lineCounter = lineCounterForFile(fileName);

        Thread thread = new Thread(lineCounter);
        thread.start();

        // We need a join() so we can get the final count of
        // all lines in all files after all threads have finished
        thread.join();

    }

    private Runnable lineCounterForFile(String fileName) {
        return new LineCounter(fileName, resultsConsumer(), counterForAllThreads);
    }

    private Consumer<LineCountingResults> resultsConsumer() {
        return results -> userInterface.display(results);
    }

    private void displayTotalLineCount() {
        userInterface.displayTotalLineCount(totalLineCount());
    }

    private long totalLineCount() {
        return counterForAllThreads.get();
    }

}
