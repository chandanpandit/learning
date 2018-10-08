package com.chandan.concurrency;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides synchronized implementation of HashMap
 */
public class ConcurrentHashMapExample {
   public static void main(String[] args) {
      ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
      new Thread(new Producer2(map)).start();
      new Thread(new Consumer2(map)).start();
   }
}

class Producer2 implements Runnable {
   private ConcurrentHashMap<String, Integer> map;

   public Producer2(ConcurrentHashMap<String, Integer> map) {
      this.map = map;
   }

   @Override
   public void run() {
      try {
         map.put("A", 1);
         Thread.sleep(1000);
         map.put("B", 2);
         map.put("C", 3);
         Thread.sleep(1000);
         map.put("D", 4);
         Thread.sleep(1000);
         map.put("E", 5);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class Consumer2 implements Runnable {
   private ConcurrentHashMap<String, Integer> map;

   public Consumer2(ConcurrentHashMap<String, Integer> map) {
      this.map = map;
   }

   @Override
   public void run() {
      try {
         Thread.sleep(5000);
         System.out.println(map.get("A"));
         System.out.println(map.get("B"));
         System.out.println(map.get("C"));
         System.out.println(map.get("D"));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
