package com.chandan.concurrency;

import java.util.LinkedList;

public class ProducerConsumerTest {
   public static void main(String[] args) throws InterruptedException {
      PCAnother another = new PCAnother(5);
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               another.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               another.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t1.start();
      t2.start();
      t1.join();
      t2.join();
   }
}
class PCAnother{
   private LinkedList<Integer> list;
   int capacity;
   int counter;

   public PCAnother(int capacity) {
      this.list = new LinkedList<>();
      this.capacity = capacity;
      counter = 1;
   }

   // will wait until size is equal to capacity
   public void produce() throws InterruptedException {
      while (true) {
         synchronized (this) {
            while (list.size() >= capacity)
               wait();
            System.out.println("Produced : "+counter);
            list.add(counter++);
            notifyAll();
         }
         Thread.sleep(100);
      }
   }
   public void consume() throws InterruptedException {
      while (true) {
         synchronized (this) {
            while (list.size() == 0)
               wait();
            int consumed = list.removeFirst();
            System.out.println("Consumed : "+consumed);
            notifyAll();
         }
         Thread.sleep(200);
      }
   }
}