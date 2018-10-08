package com.chandan.concurrency;

/**
 * Here we create thread by extending java.lang.Thread
 */
public class MultiThreadingThreadExtendExample {
   public static void main(String[] args) {
      Thread t1 = new Runner11();
      Thread t2 = new Runner12();
      t1.start();
      t2.start();
      try {
         t1.join();
         t2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Finished");
   }
}

class Runner11 extends Thread {
   @Override
   public void run() {
      for (int i = 0; i < 10; i++) {
         System.out.println("Runner 1 : " + i);
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class Runner12 extends Thread {
   @Override
   public void run() {
      for (int i = 0; i < 20; i++) {
         System.out.println("Runner 2 : " + i);
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}