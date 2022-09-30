package com.alex.multithreading.counter.impl;

import com.alex.multithreading.counter.Counter;

/**
 * Decorator pattern (Design Patterns, Gang of Four)
 *
 * Wrapper for two Counter objects: One 'main' Counter object
 * and one 'secondary' Counter object.
 *
 * Each time the client code adds a value to this object,
 * both the main Counter and the secondary Counter will be updated.
 *
 * @author Alex Angulo
 */
public class DoubleCounterDecorator implements Counter {

    private final Counter mainCounter;
    private final Counter secondaryCounter;


    public DoubleCounterDecorator(Counter mainCounter, Counter secondaryCounter) {
        this.mainCounter = mainCounter;
        this.secondaryCounter = secondaryCounter;
    }

    /**
     * Update the value for both Counter objects
     *
     * @param value the value to add to both Counter objects
     */
    @Override
    public void add(long value) {
        mainCounter.add(value);
        secondaryCounter.add(value);
    }

    /**
     * Get value of the main Counter
     *
     * @return the value of the main Counter
     */
    @Override
    public long get() {
        return mainCounter.get();
    }
}
