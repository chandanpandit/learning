package com.chandan.concurrency;

/**
 * Shows the usage of synchronized method for making increment operation thread safe.
 * Without synchronized keyword result might be inconsistent
 */
public class SynchronizedExample {
   private static int counter = 0;

   private static synchronized void increment() {
      counter++;
   }

   private static Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
         for (int i = 0; i < 100; i++) {
            increment();
         }
      }
   });
   private static Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
         for (int i = 0; i < 100; i++) {
            increment();
         }
      }
   });

   static void process() {
      t1.start();
      t2.start();
      try {
         t1.join();
         t2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println(counter);
   }

   public static void main(String[] args) {
      process();
   }
}