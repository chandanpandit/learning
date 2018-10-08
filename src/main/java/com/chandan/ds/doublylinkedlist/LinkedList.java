package com.chandan.ds.doublylinkedlist;

public interface LinkedList<E> {
   int size();
   E get(int index) throws Exception;
   void set(int index,E e);
   void remove(int index);
}
