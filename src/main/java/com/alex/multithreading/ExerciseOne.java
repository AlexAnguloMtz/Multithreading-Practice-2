package com.alex.multithreading;

import com.alex.multithreading.line.counter.app.LineCounterApp;
import com.alex.multithreading.counter.SimpleCounter;

/**
 * Run the application with a non-synchronized counter for all Thread objects
 */

class ExerciseOne {

    public static void main(String[] args) {

        display("\nRunning app with a non-synchronized counter");

        new LineCounterApp(new SimpleCounter()).run(args);

    }

    private static void display(String message) {
        System.out.println(message);
    }

}