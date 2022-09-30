package com.alex.multithreading;

import java.io.File;

/**
 *  Data transfer class to transport the name of a file
 *  and the number of lines it contains
 *
 *  @author Alex Angulo
 */
class LineCountingResults {

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
