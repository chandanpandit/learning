package com.chandan.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chandan on 26/9/18.
 */
public class BlockingQueueExample {
   public static void main(String[] args) {
      BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10, true);
      Producer producer = new Producer(queue);
      Consumer consumer = new Consumer(queue);
      new Thread(producer).start();
      new Thread(consumer).start();
   }
}

class Producer implements Runnable {
   private BlockingQueue<Integer> queue;

   public Producer(BlockingQueue<Integer> queue) {
      this.queue = queue;
   }

   @Override
   public void run() {
      int counter = 0;
      while (true) {
         try {
            Thread.sleep(500);
            counter++;
            queue.put(counter);
            System.out.println("Produced : " + counter);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class Consumer implements Runnable {
   private BlockingQueue<Integer> queue;

   public Consumer(BlockingQueue<Integer> queue) {
      this.queue = queue;
   }

   @Override
   public void run() {
      int counter = 0;
      while (true) {
         try {
            Thread.sleep(1000);
            int value = queue.take();
            System.out.println("Consumed : " + value);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}