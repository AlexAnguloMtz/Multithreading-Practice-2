package com.alex.multithreading.line.counter.app;

/**
 *  Immutable data transfer class to transport the obtained results
 *
 *  @author Alex Angulo
 */
public class LineCountingResults {

    private final String threadName;
    private final String fileName;
    private final long numberOfLines;
    private final long millisecondsPassed;

    public LineCountingResults(String threadName,
                               String filename,
                               long numberOfLines,
                               long millisecondsPassed) {
        this.threadName = threadName;
        this.fileName = filename;
        this.numberOfLines = numberOfLines;
        this.millisecondsPassed = millisecondsPassed;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getNumberOfLines() {
        return numberOfLines;
    }

    public long getMillisecondsPassed() {
        return millisecondsPassed;
    }
}
