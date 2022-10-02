package com.alex.multithreading.task.decorator;

import com.alex.multithreading.task.Task;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;

public class HelloThreadDecorator extends TaskDecorator {

    private static final String HELLO_FROM_THREAD = "Hello from Thread: %s";

    public HelloThreadDecorator(Task task) {
        super(task);
    }

    @Override
    public List<String> execute() {
        return resultsOfExecution();
    }

    @Override
    protected List<String> resultsOfWrappedTask() {
        return super.execute();
    }

    protected String resultOfThisTask() {
        return helloThreadMessage();
    }

    private String helloThreadMessage() {
        return format(HELLO_FROM_THREAD, threadName());
    }

    private String threadName() {
        return currentThread().getName();
    }

}