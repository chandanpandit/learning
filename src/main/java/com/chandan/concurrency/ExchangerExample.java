package com.chandan.concurrency;

import java.util.concurrent.Exchanger;

/**
 * Exchangers can be used to exchange objectes between two threads.
 * If first thread sends an object to another thread, then it has to receive another object
 * from second thread as well.
 * Thread 1 ----Obj1---->  Thread 2
 * Thread 2 ----Obj1---->  Thread 1
 */
public class ExchangerExample {
   public static void main(String[] args) {
      Exchanger<Integer> exchanger = new Exchanger<>();
      Thread t1 = new Thread(new Worker5(exchanger));
      Thread t2 = new Thread(new Worker6(exchanger));
      t1.start();
      t2.start();
   }
}

class Worker5 implements Runnable {
   private int counter;
   private Exchanger<Integer> exchanger;

   public Worker5(Exchanger<Integer> exchanger) {
      this.exchanger = exchanger;
   }

   public void setCounter(int counter) {
      this.counter = counter;
   }

   @Override
   public void run() {
      while (true) {
         try {
            Thread.sleep(1000);
            counter++;
            System.out.println("Increment by first thread =" + counter);
            counter = exchanger.exchange(counter);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class Worker6 implements Runnable {
   private int counter;
   private final Exchanger<Integer> exchanger;

   public Worker6(Exchanger<Integer> exchanger) {
      this.exchanger = exchanger;
   }

   public void setCounter(int counter) {
      this.counter = counter;
   }

   @Override
   public void run() {
      while (true) {
         try {
            Thread.sleep(1000);
            counter--;
            System.out.println("Decrement by second thread =" + counter);
            counter = exchanger.exchange(counter);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}