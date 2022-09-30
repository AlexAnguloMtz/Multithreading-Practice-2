package com.alex.multithreading.line.counter.app;

import lombok.Data;

/**
 *  Immutable data transfer class to transport the obtained results
 *
 *  @author Alex Angulo
 */

@Data
public class LineCountingResults {

    private final String threadName;

    private final String fileName;

    private final long numberOfLines;

    private final long millisecondsPassed;

}
