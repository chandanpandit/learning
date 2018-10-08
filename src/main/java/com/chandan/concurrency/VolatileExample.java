package com.chandan.concurrency;

/**
 * If you want to read/write a value of variable from main memory only(instead of CPU cache),
 * then use volatile keyword. This forces java to read write from main memory only.
 */
public class VolatileExample {
   public static void main(String[] args) {
      Worker worker = new Worker();
      Thread t1 = new Thread(worker);
      t1.start();
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      worker.setIsFinished(true);
      System.out.println("Finished");
   }
}

class Worker implements Runnable {
   private volatile boolean isFinished = false;

   @Override
   public void run() {
      while (!isFinished) {
         System.out.println("Working...");
         try {
            Thread.sleep(300);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public boolean isFinished() {
      return isFinished;
   }

   public void setIsFinished(boolean isFinished) {
      this.isFinished = isFinished;
   }
}