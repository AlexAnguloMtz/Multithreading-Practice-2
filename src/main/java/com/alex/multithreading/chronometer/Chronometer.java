package com.alex.multithreading.chronometer;

import static java.lang.System.currentTimeMillis;

/**
 * Class to measure the running time of a Runnable
 */
public class Chronometer {

    /**
     * Measures the running time of a Runnable
     *
     * @param runnable   the Runnable to run
     * @return  the time that the Runnable took to run
     */
    public long measureTime(Runnable runnable) {
        final long startingTime = currentTimeMillis();
        runnable.run();
        return currentTimeMillis() - startingTime;
    }

}
