package com.chandan.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {
   public static void main(String[] args) throws InterruptedException {
      Processor1 processor1 = new Processor1();
      Thread producerThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               processor1.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      Thread producerThread2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               processor1.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      Thread consumerThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               processor1.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      Thread consumerThread2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               processor1.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });


      long start = System.currentTimeMillis();
      producerThread.start();
      //producerThread2.start();
      consumerThread.start();
      consumerThread2.start();


      producerThread.join();
      //producerThread2.join();
      consumerThread.join();
      consumerThread2.join();

      long end = System.currentTimeMillis();
      System.out.println("Time to process 10 items = " + (end - start));
   }
}

class Processor1 {
   private static List<Integer> list = new ArrayList<>();
   private static int MAX = 5;
   private static int MIN = 0;
   private static volatile int value = 1;
   private static final Object lock = new Object();

   public void produce() throws InterruptedException {
      while (true) {
         if (value == 11) {
            break;
         }
         synchronized (lock) {
            if (list.size() == MAX) {
               System.out.println(
                  Thread.currentThread().getName() + "Capacity Full :: Waiting for consumer to consume... ");
               lock.wait();
            } else {
               Thread.sleep(300);// do processing for 300 to produce value
               System.out.println("Produced : " + value);
               list.add(value++);
               lock.notifyAll();
            }
         }
      }
   }

   public void consume() throws InterruptedException {
      while (true) {
         if (value == 11) {
            break;
         }
         synchronized (lock) {
            if (list.size() == MIN) {
               System.out.println(
                  Thread.currentThread().getName() + "Nothing to consume :: Waiting for producer to produce... ");
               lock.wait();
            } else {
               int value = list.remove(0);
               System.out.println("Consumed : " + value);
               Thread.sleep(500); // do processing for 500 ms
               lock.notifyAll();
            }
         }
      }
   }
}