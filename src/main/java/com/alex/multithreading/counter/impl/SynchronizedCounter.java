package com.alex.multithreading.counter.impl;

import com.alex.multithreading.counter.Counter;

/**
 * Synchronized implementation of a Counter
 *
 * @author Alex Angulo
 */
public class SynchronizedCounter implements Counter {

    private long count;

    /**
     * Add the received value to the count in a synchronized manner
     *
     * @param value the value to add
     */
    public synchronized void add(long value) {
        count += value;
    }

    /**
     * Get the value of this Counter object
     *
     * @return the value of this Counter object
     */
    public long get() {
        return count;
    }

}
