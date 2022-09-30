package com.alex.multithreading;

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