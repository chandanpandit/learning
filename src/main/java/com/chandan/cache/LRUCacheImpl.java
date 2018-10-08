package com.chandan.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl<K, V> {
   class Node<P, Q> {
      P key;
      Q value;
      Node<P, Q> prev;
      Node<P, Q> next;

      public Node(P key, Q value) {
         this.key = key;
         this.value = value;
         prev = null;
         next = null;
      }
   }

   private int capacity;
   private Node<K, V> head;
   private Node<K, V> tail;
   private Map<K, Node<K, V>> cache;

   public LRUCacheImpl(int capacity) {
      this.capacity = capacity;
      head = null;
      tail = null;
      cache = new HashMap<K, Node<K, V>>();
   }

   public V get(K key) {
      if (cache.containsKey(key)) {
         Node<K, V> n = cache.get(key);
         remove(n);
         setHead(n);
         return n.value;
      }
      return null;
   }

   public void put(K key, V value) {
      if (cache.containsKey(key)) {
         Node<K, V> n = cache.get(key);
         remove(n);
         setHead(n);
         n.value = value;
      } else {
         Node<K, V> newNode = new Node<>(key, value);
         if (cache.size() >= capacity) {
            cache.remove(tail.key);
            remove(tail);
         }
         setHead(newNode);
         cache.put(key, newNode);
      }
   }

   private void remove(Node<K, V> n) {
      if (n.prev != null) {
         n.prev.next = n.next;
      } else {
         head = n.next;
      }

      if (n.next != null) {
         n.next.prev = n.prev;
      } else {
         tail = n.prev;
      }
   }

   private void setHead(Node<K, V> n) {
      n.next = head;
      if (head != null) {
         head.prev = n;
      }
      head = n;
      if (tail == null) {
         tail = head;
      }
   }

   public void printCache(){
      Node<K,V> temp = head;
      System.out.print("Cache : [");
      while (temp != null){
         System.out.print(temp.value + ", ");
         temp = temp.next;
      }
      System.out.println("]");
   }
}

class Test {
   public static void main(String[] args) {
      LRUCacheImpl<String, Person> cache = new LRUCacheImpl<>(5);
      cache.put("chandan", new Person("Chandan"));
      cache.printCache();
      cache.put("aman", new Person("Aman"));
      cache.printCache();
      cache.put("raj", new Person("Raj"));
      cache.printCache();
      cache.put("rohit", new Person("Rohit"));
      cache.printCache();
      System.out.println("Getting chandan :: " + cache.get("chandan"));
      cache.printCache();
      System.out.println("Getting aman :: "+cache.get("aman"));
      cache.printCache();
      cache.put("ram", new Person("Ram"));
      cache.printCache();
      System.out.println("Getting aman :: "+cache.get("aman"));
      cache.printCache();
   }
}

class Person {
   private String name;

   public Person(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Person{" +
             "name='" + name + '\'' +
             '}';
   }
}