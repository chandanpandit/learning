package com.chandan.concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chandan on 23/9/18.
 * Shows usage of cyclic-barrier. It is same as Latches but it can be re-used.
 */
public class CyclicBarrierExample {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(5);
      CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
         @Override
         public void run() {
            System.out.println("All tasks finished!");
         }
      });
      for (int i = 0; i < 5; i++) {
         executorService.submit(new Worker4(i + 1, cyclicBarrier));
      }

      executorService.shutdown();
   }
}

class Worker4 implements Runnable {

   private int id;
   private CyclicBarrier cyclicBarrier;
   private Random random;

   public Worker4(int id, CyclicBarrier cyclicBarrier) {
      this.id = id;
      this.cyclicBarrier = cyclicBarrier;
      random = new Random();
   }

   @Override
   public void run() {
      System.out.println("Started thread " + id + "....");
      try {
         Thread.sleep(random.nextInt(3000));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Thread "+id+" Done...");
      try {
         cyclicBarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
         e.printStackTrace();
      }
      System.out.println("After barrier...");
   }
}