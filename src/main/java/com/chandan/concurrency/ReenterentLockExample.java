package com.chandan.concurrency;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.lock() & lock.unlock() is similar to a synchronized block. With one advantage that lock can be
 * released in a different method as well.
 * Caution : Always put lock unlock thing in a try catch block. So that in case any exception is there,
 * lock is released. Otherwise, application will go to deadlock as it will not release that lock.
 */

public class ReenterentLockExample {
   private static int counter = 0;
   private static Lock lock = new ReentrantLock();

   private static void increment() {
      try {
         lock.lock();
         for (int i = 0; i < 1000000; i++) {
            counter++;
            //throw new NullPointerException("Test");
         }
      } catch (Exception e) {
         System.out.println("Something went Wrong");
      } finally {
         lock.unlock();
      }
   }

   public static void main(String[] args) {
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            increment();
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            increment();
         }
      });

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
}