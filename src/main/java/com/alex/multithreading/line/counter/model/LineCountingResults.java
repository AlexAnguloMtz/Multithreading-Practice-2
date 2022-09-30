package com.alex.multithreading.line.counter.model;

/**
 *  Immutable data transfer class to transport the
 *  obtained results when running the application
 *
 *  @author Alex Angulo
 */
public class LineCountingResults {

    private final String threadName;
    private final String fileName;
    private final long numberOfLines;
    private final long milliseconds;

    public LineCountingResults(String threadName,
                               String filename,
                               long numberOfLines,
                               long milliseconds) {
        this.threadName = threadName;
        this.fileName = filename;
        this.numberOfLines = numberOfLines;
        this.milliseconds = milliseconds;
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

    public long getMilliseconds() {
        return milliseconds;
    }
}
