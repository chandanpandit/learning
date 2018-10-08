package com.chandan.ds.linkedlist;

public class Node<E> {
   E data;
   Node<E> next;

   public Node(E data) {
      this.data = data;
   }

   public Node(E data,Node<E> prev) {
      this(data);
      this.next = prev.next;
      prev.next = this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      E testData = (E)o;
      return data.equals(testData);
   }

   @Override
   public int hashCode() {
      int result = data != null ? data.hashCode() : 0;
      result = 31 * result + (next != null ? next.hashCode() : 0);
      return result;
   }
}
