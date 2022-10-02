package com.alex.multithreading;

import com.alex.multithreading.application.Application;
import com.alex.multithreading.counter.impl.SynchronizedCounter;

/**
 * Run the application with a synchronized counter for all Thread objects
 */

class ExerciseTwo extends AbstractExercise {

    public static void main(String[] args) {

        display("\nRunning app with a synchronized counter\n");

        new Application(new SynchronizedCounter()).runWithFiles(args);

    }

}