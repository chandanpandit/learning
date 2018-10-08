package com.chandan.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chandan on 23/9/18.
 * Show usage of countdown latch. It is one of the method of thread synchronization. One thread which calls
 * await on the latch, waits until the count specified in latch is reached. Then it continues working.
 */
public class CountDownLatchExample {
   public static void main(String[] args) {
      CountDownLatch latch = new CountDownLatch(6);
      ExecutorService service = Executors.newFixedThreadPool(5);
      for (int i = 0; i < 5; i++) {
         service.submit(new Worker3(i + 1, latch));
      }
      System.out.println("Waiting for threads to finish their tasks...");
      try {
         latch.await();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("All tasks finished!");
      service.shutdown();
   }
}

class Worker3 implements Runnable {
   private int id;
   CountDownLatch countDownLatch;

   public Worker3(int id, CountDownLatch countDownLatch) {
      this.id = id;
      this.countDownLatch = countDownLatch;
   }

   void doWork() {
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      countDownLatch.countDown();
   }

   @Override
   public void run() {
      System.out.println("Thread " + id + " started to work...");
      doWork();
   }
}