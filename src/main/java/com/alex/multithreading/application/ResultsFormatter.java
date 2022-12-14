package com.alex.multithreading.application;

import java.util.List;

import static java.lang.String.format;

public class ResultsFormatter {
    String formatResults(List<String> resultsOfExecution) {
        var builder = new StringBuilder();
        for (String string : resultsOfExecution) {
            builder.append(format("%s%n", string));
        }
        return builder.toString();
    }

}
