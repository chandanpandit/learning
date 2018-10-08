package com.chandan.cache;

public interface ILRUCache<K, V> {
   V get(K key);

   void put(K key, V value);
}
