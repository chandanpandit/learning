package com.chandan.concurrency;

public class PrintOddEvenByThread {
   public static void main(String[] args) throws InterruptedException {
      OddEvenPrinter printer = new OddEvenPrinter(100);
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               printer.printFirst();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               printer.printSecond();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      Thread t3 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               printer.printThird();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t1.setName("First Printer : ");
      t2.setName("Second Printer : ");
      t3.setName("Third Printer : ");
      t1.start();
      t2.start();
      t3.start();
      t1.join();
      t2.join();
      t3.join();
   }
}

class OddEvenPrinter {
   private int limit;
   private int counter;

   public OddEvenPrinter(int limit) {
      this.limit = limit;
      counter = 0;
   }

   public void printFirst() throws InterruptedException {
      while (counter < limit) {
         synchronized (this) {
            while (counter % 3 != 0) {
               wait();
            }
            System.out.println(Thread.currentThread().getName()+" : "+counter++);
            notifyAll();
         }
      }
   }

   public void printSecond() throws InterruptedException {
      while (counter < limit) {
         synchronized (this) {
            while (counter % 3 != 1) {
               wait();
            }
            System.out.println(Thread.currentThread().getName()+" : "+counter++);
            notifyAll();
         }
         Thread.sleep(1000);
      }
   }

   public void printThird() throws InterruptedException {
      while (counter < limit) {
         synchronized (this) {
            while (counter % 3 != 2) {
               wait();
            }
            System.out.println(Thread.currentThread().getName()+" : "+counter++);
            notifyAll();
         }
         Thread.sleep(1000);
      }
   }
}