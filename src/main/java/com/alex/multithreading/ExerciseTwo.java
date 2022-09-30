package com.alex.multithreading;

import com.alex.multithreading.counter.impl.SynchronizedCounter;
import com.alex.multithreading.line.counter.app.LineCounterApp;

/**
 * Run the application with a synchronized counter for all Thread objects
 */

class ExerciseTwo {

    public static void main(String[] args) {

        display("\nRunning app with a synchronized counter");

        new LineCounterApp(new SynchronizedCounter()).run(args);

    }

    private static void display(String message) {
        System.out.println(message);
    }

}