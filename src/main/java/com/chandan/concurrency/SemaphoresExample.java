package com.chandan.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Why : Counter based lock
 * Use Cases : To limit the number of concurrent connections to a file-server
 */
public class SemaphoresExample {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newCachedThreadPool();
      for (int i = 0; i < 10; i++) {
         executorService.execute(new Runnable() {
            @Override
            public void run() {
               Downloader.INSTANCE.downloadData();
            }
         });
      }

     executorService.shutdown();
   }
}

enum Downloader {
   INSTANCE;

   private Semaphore semaphore = new Semaphore(7, true);

   public void downloadData() {
      try {
         semaphore.acquire();
         download();
         semaphore.release();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private void download() {
      try {
         System.out.println("Downlading data...");
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}