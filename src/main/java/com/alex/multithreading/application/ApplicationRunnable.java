package com.alex.multithreading.application;

import com.alex.multithreading.counter.Counter;
import com.alex.multithreading.task.Task;
import com.alex.multithreading.task.decorator.ChronometerDecorator;
import com.alex.multithreading.task.decorator.HelloThreadDecorator;
import com.alex.multithreading.task.impl.CountLinesTask;

import java.util.List;

public class ApplicationRunnable implements Runnable {

    private final String fileName;
    private final Counter counter;
    private final ResultsFormatter resultsFormatter;

    public ApplicationRunnable(String fileName, Counter counter) {
        this.fileName = fileName;
        this.counter = counter;
        this.resultsFormatter = new ResultsFormatter();
    }

    @Override
    public void run() {

        // Initial task
        Task countLinesTask = new CountLinesTask(fileName, counter);

        // Decorate the initial task with some Decorators
        Task chronometerDecorator = new ChronometerDecorator(countLinesTask);
        Task helloThreadDecorator = new HelloThreadDecorator(chronometerDecorator);

        // Get the results of executing all tasks
        List<String> resultsOfAllTasks = helloThreadDecorator.execute();

        String formattedResults = formatResults(resultsOfAllTasks);
        display(formattedResults);

    }

    private String formatResults(List<String> resultsOfAllTasks) {
        return resultsFormatter.formatResults(resultsOfAllTasks);
    }

    private void display(String message) {
        System.out.println(message);
    }

}
