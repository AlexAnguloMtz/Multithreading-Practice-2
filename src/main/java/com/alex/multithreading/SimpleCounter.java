package com.alex.multithreading;

class SimpleCounter implements Counter {
    
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
