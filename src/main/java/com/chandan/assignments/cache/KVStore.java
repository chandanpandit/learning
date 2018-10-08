package com.chandan.assignments.cache;

/**
 * Created by chandan on 31/3/18.
 */
public interface KVStore<K,V> {
   V get (K key);
   void put (K key, V value);
   void delete (K key);
   void clear ();
   long size ();
}
