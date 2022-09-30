package com.alex.multithreading.counter.impl;

import com.alex.multithreading.counter.Counter;

/**
 * Non synchronized implementation of a Counter
 *
 * @author Alex Angulo
 */
public class SimpleCounter implements Counter {
    
     private long count;
     
     public SimpleCounter() {
         count = 0;
     }

    /**
     * Add the received value to the count
     *
     * @param value the value to add
     */
    public void add(long value){
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
