package com.alex.multithreading.task.decorator;

import com.alex.multithreading.task.Task;
import com.alex.multithreading.chronometer.Chronometer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class ChronometerDecorator extends TaskDecorator {

    private static final String RESULTS_TEMPLATE = "Time spent: %d milliseconds";

    private final Chronometer chronometer;
    private List<String> resultsOfWrappedTask;
    private long timePassed;

    public ChronometerDecorator(Task task) {
        super(task);
        this.chronometer = new Chronometer();
    }

    @Override
    public List<String> execute() {
        setFieldsWithDecoratedTask();
        return results();
    }

    private List<String> results() {
        List<String> results = new ArrayList<>();
        results.add(resultForThisTask());
        results.addAll(this.resultsOfWrappedTask);
        return results;
    }

    private String resultForThisTask() {
        return format(RESULTS_TEMPLATE, this.timePassed);
    }

    private void setFieldsWithDecoratedTask() {
        this.timePassed = chronometer.measureTime( () -> setWrappedTaskResult() );
    }

    private void setWrappedTaskResult() {
        this.resultsOfWrappedTask = super.execute();
    }

}
