package com.chandan.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition.await() -> object.wait()
 * condition.signal() -> object.notify()
 * condition.signalAll() -> object.notifyAll()
 */
public class AwaitAndSignalExample {
   public static void main(String[] args) {
      Worker1 worker1 = new Worker1();

      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               worker1.produce();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               worker1.consume();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      t1.start();
      t2.start();

      try {
         t1.join();
         t2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class Worker1 {
   private Lock lock = new ReentrantLock();
   private Condition condition = lock.newCondition();

   public void produce() throws InterruptedException {
      lock.lock();

      System.out.println("Inside Produce");
      condition.await();
      System.out.println("Exiting Produce");

      lock.unlock();
   }

   public void consume() throws InterruptedException {
      lock.lock();

      Thread.sleep(2000);
      System.out.println("Inside consume");
      condition.signal();

      lock.unlock();
   }

}