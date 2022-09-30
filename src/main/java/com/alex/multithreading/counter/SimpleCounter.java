package com.alex.multithreading.counter;

public class SimpleCounter implements Counter {
    
     private long count;
     
     public SimpleCounter() {
         count = 0;
     }
     
     public SimpleCounter(long n) {
         count = n;
         
     }

     public void add(long value){
         count += value;
     }
     
     public long get() {
         return count;
     }
    
}
