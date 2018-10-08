package com.chandan.concurrency;

public class WaitNotifyExample {
   public static void main(String[] args) throws InterruptedException {
      Processor processor = new Processor();
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               processor.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            processor.consume();
         }
      });

      t1.start();
      t2.start();
      t1.join();
      t2.join();
   }
}

class Processor {
   public void produce() throws InterruptedException {
      synchronized (this) {
         System.out.println("Inside Produce...");
         wait();
         System.out.println("Exiting Produce method!");
      }
   }

   public void consume() {
      synchronized (this) {
         System.out.println("Consuming");
         notify();
      }
   }
}