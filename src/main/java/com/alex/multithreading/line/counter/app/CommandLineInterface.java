package com.alex.multithreading.line.counter.app;

import com.alex.multithreading.line.counter.model.LineCountingResults;

import static java.lang.String.format;

/**
 * Representation of a command line interface
 *
 * @author Alex Angulo
 */
public class CommandLineInterface {

    private static final String RESULTS_TEMPLATE =
            "\nThread name: %s \nFile: %s \nNumber of lines: %d \nTime passed: %d milliseconds";

    private static final String TOTAL_NUMBER_OF_LINES = "\nTotal number of lines in all files: %d";
    private static final String TOTAL_TIME_SPENT = "Time spent in counting all lines: %d milliseconds";


    public void display(LineCountingResults results) {
        displayMessage(messageOf(results));
    }

    private String messageOf(LineCountingResults results) {
        return format(RESULTS_TEMPLATE,
                results.getThreadName(), results.getFileName(), results.getNumberOfLines(), results.getMilliseconds());
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTotalLineCount(long totalNumberOfLines) {
        displayMessage(format(TOTAL_NUMBER_OF_LINES, totalNumberOfLines));
    }


    public void displayTotalTime(long totalTime) {
        displayMessage(format(TOTAL_TIME_SPENT, totalTime));
    }
}