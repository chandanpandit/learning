package com.chandan.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Tests the use cases of various ways of using executor service
 */
public class ExecutorServiceTest {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newCachedThreadPool();
      for (int i = 0; i < 5; i++) {
         executorService.submit(new Task());
      }
      executorService.shutdown();
   }
}

class Task implements Runnable {

   @Override
   public void run() {
      for (int i = 0; i < 10; i++) {
         System.out.println(i);
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}