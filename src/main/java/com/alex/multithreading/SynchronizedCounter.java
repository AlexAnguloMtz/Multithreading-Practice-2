package com.alex.multithreading;

class SynchronizedCounter implements Counter {

    private long count;

    public synchronized void add(long value) {
        count += value;
    }

    public long get() {
        return count;
    }

}
