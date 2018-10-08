package com.chandan.ds.map;

/**
 * Custom hashmap implementation
 */
interface ICustomHashMap<K, V> {
   void put(K key, V value);

   V get(K key);

   boolean containsKey(K key);

   void display();

   boolean remove(K key);
}

public class CustomHashMap<K, V> implements ICustomHashMap<K, V> {

   // array to store entry objects. This will support chaining if collision occurs
   private Entry<K, V>[] table;
   private int capacity = 4;

   @SuppressWarnings("unchecked")
   public CustomHashMap() {
      table = new Entry[capacity];
   }

   @Override
   public void put(K key, V value) {
      int bucketIndex = Math.abs(key.hashCode() % capacity);
      Entry<K, V> curr = table[bucketIndex];
      if (curr == null) {
         table[bucketIndex] = new Entry<>(key, value, null);
      } else {
         boolean flag = false;
         Entry<K, V> prev = null;
         while (curr != null) {
            if (curr.key.equals(key)) {
               curr.value = value;
               flag = true;
               break;
            }
            prev = curr;
            curr = curr.next;
         }
         if (!flag) {
            prev.next = new Entry<>(key, value, null);
         }
      }
   }

   @Override
   public V get(K key) {
      int bucketIndex = Math.abs(key.hashCode() % capacity);
      Entry<K, V> curr = table[bucketIndex];
      while (curr != null) {
         if (curr.key.equals(key)) {
            return curr.value;
         }
         curr = curr.next;
      }

      return null;
   }

   @Override
   public boolean containsKey(K key) {
      int bucketIndex = Math.abs(key.hashCode() % capacity);
      Entry<K, V> curr = table[bucketIndex];
      while (curr != null) {
         if (curr.key.equals(key)) {
            return true;
         }
         curr = curr.next;
      }

      return false;
   }

   @Override
   public void display() {
      for (int i = 0; i < capacity; i++) {
         System.out.print(i + " : ");
         Entry<K, V> curr = table[i];
         while (curr != null) {
            System.out.print("[" + curr.key + "," + curr.value + "] ->");
            curr = curr.next;
         }
         System.out.println("NULL");
      }
   }

   @Override
   public boolean remove(K key) {
      int bucketIndex = Math.abs(key.hashCode() % capacity);
      Entry<K, V> curr = table[bucketIndex];
      Entry<K, V> prev = null;
      boolean removed = false;
      while (curr != null) {
         if (curr.key.equals(key)) { // node found. remove it
            if (prev == null) { // first node
               table[bucketIndex] = curr.next;
            } else {
               prev.next = curr.next;
            }
            removed = true;
            break;
         }
         prev = curr;
         curr = curr.next;
      }

      return removed;
   }

   static class Entry<K, V> {
      K key;
      V value;
      Entry<K, V> next;

      public Entry(K key, V value, Entry<K, V> next) {
         this.key = key;
         this.value = value;
         this.next = next;
      }
   }

}