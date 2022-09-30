package com.alex.multithreading.line.counter.app;

import com.alex.multithreading.line.counter.model.LineCountingResults;

import static java.lang.String.format;

/**
 * Representation of a command line interface
 *
 * @author Alex Angulo
 */
public class CommandLineInterface {

    private static final String NUMBER_OF_LINES_IN_FILE_MESSAGE =
            "\nThread name: %s \nFile: %s \nNumber of lines: %d \nTime passed: %d milliseconds";

    private static final String TOTAL_NUMBER_OF_LINES = "\nTotal number of lines in all files: %d";


    public void display(LineCountingResults results) {
        displayMessage(messageOf(results));
    }

    private String messageOf(LineCountingResults results) {
        return format(NUMBER_OF_LINES_IN_FILE_MESSAGE,
                results.getThreadName(), results.getFileName(), results.getNumberOfLines(), results.getMilliseconds());
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTotalLineCount(long totalNumberOfLines) {
        displayMessage(format(TOTAL_NUMBER_OF_LINES, totalNumberOfLines));
    }
}