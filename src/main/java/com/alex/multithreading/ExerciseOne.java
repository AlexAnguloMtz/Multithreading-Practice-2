package com.alex.multithreading;

import com.alex.multithreading.application.Application;
import com.alex.multithreading.counter.impl.SimpleCounter;

/**
 * Run the application with a non-synchronized counter for all Thread objects
 */

class ExerciseOne extends AbstractExercise {

    public static void main(String[] args) {

        display("\nRunning app with a non-synchronized counter\n");

        new Application(new SimpleCounter()).runWithFiles(args);

    }

}