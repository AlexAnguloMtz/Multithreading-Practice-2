package com.alex.multithreading;

import com.alex.multithreading.application.Application;
import com.alex.multithreading.counter.impl.SynchronizedCounter;

/**
 * Run the application with a synchronized counter for all Thread objects
 */

class ExerciseTwo {

    public static void main(String[] args) {

        display("\nRunning app with a synchronized counter");

        new Application(new SynchronizedCounter()).runWithFiles(args);

    }

    private static void display(String message) {
        System.out.println(message);
    }

}