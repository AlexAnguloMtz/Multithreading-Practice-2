package com.alex.multithreading;

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