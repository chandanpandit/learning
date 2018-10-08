package com.chandan.concurrency;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by chandan on 26/9/18.
 */
public class DelayedQueueExample {
   public static void main(String[] args) {
      DelayQueue<Delayed> queue = new DelayQueue<>();
      queue.add(new DelayedWorker("Hi", 1000));
      queue.add(new DelayedWorker("Pandit", 10000));
      queue.add(new DelayedWorker("Chandan", 4000));
      System.out.println("put everything..now..taking out...");
      while (!queue.isEmpty()) {
         try {
            System.out.println(queue.take());
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class DelayedWorker implements Delayed {
   private String message;
   private long duration;

   public DelayedWorker(String message, long duration) {
      this.message = message;
      this.duration = System.currentTimeMillis() + duration;
   }

   @Override
   public long getDelay(TimeUnit unit) {
      return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
   }

   @Override
   public int compareTo(Delayed another) {
      if (this.duration < ((DelayedWorker) another).duration) {
         return -1;
      } else {
         return 1;
      }
   }
   
   @Override
   public String toString() {
      return message;
   }
}