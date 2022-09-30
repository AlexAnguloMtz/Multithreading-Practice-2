package com.alex.multithreading.counter;

/**
 * Abstract representation of a counter
 *
 * @author Alex Angulo
 */
public interface Counter {

    /**
     * Add the received value to the count
     *
     * @param value the value to add
     */
    void add(long value);

    /**
     * Get the value of this Counter object
     *
     * @return the value of this Counter object
     */
    long get();

}
