package com.alex.multithreading.task.decorator;

import com.alex.multithreading.task.Task;

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

    @Override
    public List<String> execute() {
        return task.execute();
    }

}