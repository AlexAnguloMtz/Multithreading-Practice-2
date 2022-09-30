package com.alex.multithreading.line.counter.app;

import com.alex.multithreading.counter.Counter;

/**
 * Decorator pattern (Design Patterns, Gang of Four)
 *
 * Wrapper for two Counter objects: One Counter for an individual Thread
 * and one Counter to be shared by all the Thread objects.
 *
 * The purpose of this class is so that the model code
 * does not need to know the existence of more than one Counter object.
 *
 * Each time the model code adds a value to its individual line count,
 * the Counter shared by all Threads will also be updated.
 *
 * @author Alex Angulo
 */
public class DoubleCounterDecorator implements Counter {

    private final Counter counterForOneThread;
    private final Counter counterForAllThreads;


    public DoubleCounterDecorator(Counter counterForOneThread, Counter counterForAllThreads) {
        this.counterForOneThread = counterForOneThread;
        this.counterForAllThreads = counterForAllThreads;
    }

    /**
     * Update the value for the individual Counter
     * for the current Thread, and also for the Counter shared by all Threads
     *
     * @param value the value to add to both Counter objects
     */
    @Override
    public void add(long value) {
        counterForOneThread.add(value);
        counterForAllThreads.add(value);
    }

    /**
     * Get value of the individual Counter for the current Thread
     *
     * @return the value of the individual Counter for the current Thread
     */
    @Override
    public long get() {
        return counterForOneThread.get();
    }
}
