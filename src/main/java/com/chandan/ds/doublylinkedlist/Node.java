package com.chandan.ds.doublylinkedlist;

class Node<E> {
   E data;
   Node<E> next;
   Node<E> prev;

   public Node(E data) {
      this.data = data;
   }
}
