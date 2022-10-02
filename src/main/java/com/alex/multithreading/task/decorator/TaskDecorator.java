package com.alex.multithreading.task.decorator;

import com.alex.multithreading.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 *  Decorator Pattern (Design Patterns, Gang of Four)
 *
 *  @author Alex Angulo
 */
public abstract class TaskDecorator implements Task {

    private final Task task;

    public TaskDecorator(Task task) {
        this.task = task;
    }

    protected abstract String resultOfThisTask();

    protected abstract List<String> resultsOfWrappedTask();

    @Override
    public List<String> execute() {
        return task.execute();
    }

    protected List<String> resultsOfExecution() {
        List<String> resultsOfExecution = new ArrayList<>();
        resultsOfExecution.add(resultOfThisTask());
        resultsOfExecution.addAll(resultsOfWrappedTask());
        return resultsOfExecution;
    }

}