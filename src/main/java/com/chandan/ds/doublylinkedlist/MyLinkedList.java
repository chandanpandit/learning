package com.chandan.ds.doublylinkedlist;

public class MyLinkedList<E> implements LinkedList<E>{
   private int size;
   private Node<E> head;
   private Node<E> tail;

   public MyLinkedList() {
      head = new Node<>(null);
      tail = new Node<>(null);
      size = 0;
   }


   @Override
   public int size() {
      return size;
   }

   @Override
   public E get(int index) throws Exception {
      int i = 0;
      Node<E> temp = head;
      while (i < index && temp!= null){
         temp = temp.next;
      }
      if(i != index){
         throw new Exception("Invalid index");
      }

      return temp.data;
   }

   @Override
   public void set(int index,E e) {

   }

   @Override
   public void remove(int index) {

   }
}
