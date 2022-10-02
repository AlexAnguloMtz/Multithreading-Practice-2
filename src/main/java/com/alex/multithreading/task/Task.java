package com.alex.multithreading.task;

import java.util.List;

/**
 *  A Task will execute and return a List<String> representing
 *  the result of its execution
 *
 *  @author Alex Angulo
 */
public interface Task {

    /**
     * Execute this Task object and return a
     * List<String> representing the results of execution
     *
     * @return a List<String> representing
     * the results of executing this Task
     */
    List<String> execute();

}