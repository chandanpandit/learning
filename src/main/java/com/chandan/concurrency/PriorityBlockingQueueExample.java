package com.chandan.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by chandan on 6/10/18.
 */
public class PriorityBlockingQueueExample {
   public static void main(String[] args) {
      BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
      new Thread(new Producer1(queue)).start();
      new Thread(new Consumer1(queue)).start();
   }
}

class Producer1 implements Runnable {
   private BlockingQueue<Person> queue;

   public Producer1(BlockingQueue<Person> queue) {
      this.queue = queue;
   }

   @Override
   public void run() {
      try {
         queue.put(new Person(29, "Chandan"));
         queue.put(new Person(12, "Dinesh"));
         queue.put(new Person(30, "Chunkey"));
         Thread.sleep(1000);
         queue.put(new Person(87, "Ramlal"));
         Thread.sleep(1000);
         queue.put(new Person(19, "Rahul"));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class Consumer1 implements Runnable {
   private BlockingQueue<Person> queue;

   public Consumer1(BlockingQueue<Person> queue) {
      this.queue = queue;
   }

   @Override
   public void run() {
      try {
         Thread.sleep(5000);
         System.out.println(queue.take());
         System.out.println(queue.take());
         System.out.println(queue.take());
         System.out.println(queue.take());
         System.out.println(queue.take());
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class Person implements Comparable<Person> {
   private int age;
   private String name;

   public Person(int id, String name) {
      this.age = id;
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public int compareTo(Person otherPerson) {
      //this.getName().compareTo(otherPerson.getName()); // if done by name
      return Integer.compare(age, otherPerson.getAge());
   }

   @Override
   public String toString() {
      return "Person{" +
             "age=" + age +
             ", name='" + name + '\'' +
             '}';
   }
}