package com.chandan.concurrency;

public class SynchronizedBlockExample {
   private static int counter1 = 0;
   private static int counter2 = 0;

   private static Object lock1 = new Object();
   private static Object lock2 = new Object();

   static void increment1() {
      synchronized (lock1) {
         counter1++;
      }
   }

   static synchronized void increment2() {
      synchronized (lock2) {
         counter2++;
      }
   }

   static void process() {
      for (int i = 0; i < 100; i++) {
         increment1();
         increment2();
      }
   }

   public static void main(String[] args) {
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            process();
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            process();
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

      System.out.println("Counter1 = " + counter1 + " Counter2 = " + counter2);
   }
}