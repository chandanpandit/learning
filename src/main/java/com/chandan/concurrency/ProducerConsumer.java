package com.chandan.concurrency;

import java.util.LinkedList;

public class ProducerConsumer {
   public static void main(String[] args) throws InterruptedException {
      PC pc = new PC();
      Thread producer = new Thread(new Runnable(){
         @Override
         public void run() {
            try {
               pc.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread consumer = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               pc.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread consumer1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               pc.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      producer.start();
      consumer.start();
      consumer1.start();
      producer.join();
      consumer.join();
   }
}

class PC {
   private LinkedList<Integer> list = new LinkedList<>();
   int capacity = 2;

   public void produce() throws InterruptedException {
      int value = 0;
      while (true) {
         synchronized (this) {
            while (list.size() == capacity)
               wait(); // sleep until capacity is full
            System.out.println("Produced : "+value);
            list.add(value++);
            notifyAll(); //wakeup the consumer thread
            Thread.sleep(1000);
         }
      }
   }

   public void consume() throws InterruptedException {
      while (true){
         synchronized (this){
            while (list.size() == 0)
               wait(); // wait until there is nothing to consume
            System.out.println("Consumed : "+list.removeFirst()+" By "+Thread.currentThread().getName());
            notifyAll(); // notify to producer that something has been consumed
            Thread.sleep(1000);
         }
      }
   }
}