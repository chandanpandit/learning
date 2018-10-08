package com.chandan.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Shows usage of executor service to call a method & return its value
 */
public class ExecutorServiceCallableExample {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(2);
      List<Future<String>> results = new ArrayList<>();

      for (int i = 0; i < 5; i++) {
         Future<String> future = executorService.submit(new Worker2(i + 1));
         results.add(future);
      }

      /*for (int i = 4; i >= 0; i--) {
         try {
            System.out.println(results.get(i).get());
         } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
         }
      }*/

      for (int i = 0; i < 5; i++) {
         try {
            System.out.println(results.get(i).get()); // waits for result
         } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
         }
      }

      executorService.shutdown();
   }
}

class Worker2 implements Callable<String> {

   private int id;

   public Worker2(int id) {
      this.id = id;
   }

   @Override
   public String call() throws Exception {
      Thread.sleep(1000);
      return "Id=" + id;
   }
}