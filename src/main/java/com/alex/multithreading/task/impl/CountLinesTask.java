package com.alex.multithreading.task.impl;

import com.alex.multithreading.task.Task;
import com.alex.multithreading.counter.Counter;
import com.alex.multithreading.files.FileLineCounter;

import java.util.List;

import static java.lang.String.format;

public class CountLinesTask implements Task {

    private static final String RESULTS_TEMPLATE = "File name: %s %nNumber of lines: %d";

    private final String fileName;
    private final FileLineCounter lineCounter;
    private final Counter counter;

    public CountLinesTask(String fileName, Counter counter) {
        this.fileName = fileName;
        this.counter = counter;
        this.lineCounter = new FileLineCounter();
    }

    @Override
    public List<String> execute() {
        countLines();
        return results();
    }

    private List<String> results() {
        return List.of(resultsMessage());
    }

    private String resultsMessage() {
        return format(RESULTS_TEMPLATE, fileName, numberOfLines());
    }

    private void countLines() {
        lineCounter.countLinesInFile(fileName, counter);
    }

    private long numberOfLines() {
        return counter.get();
    }

}
