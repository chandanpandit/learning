package com.chandan.ds.linkedlist;

public interface LinkedList<E> {
   void add(E e);
   void remove(E e);
   boolean isEmpty();
   int size();
   boolean contains(E e);
   void printList();
   public E get(int index);
}
