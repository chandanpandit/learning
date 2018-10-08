package com.chandan.ds.linkedlist;

public class MySLLinkedList<E> implements LinkedList<E> {
   Node<E> head;
   int size;

   public MySLLinkedList() {
      size = 0;
   }

   @Override
   public void add(E e) {
      if(head == null){
         head = new Node<>(e);
      }else{
         Node<E> temp = head;
         // move temp to the last node
         while (temp.next!= null){
            temp = temp.next;
         }
         new Node<E>(e,temp);// append a node to last node
      }
      size++;
   }

   @Override
   public void remove(E e) {
      if(head != null){
         Node<E> curr = head;
         Node<E> prev = null;
         while (curr != null && !curr.equals(e)){
            prev = curr;
            curr = curr.next;
         }
         if(curr != null && curr.equals(e)) {
            if (prev == null) {
               head = head.next;
            } else {
               prev.next = curr.next;
            }
            size--;
         }
      }
   }

   @Override
   public boolean isEmpty() {
      return head == null;
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public boolean contains(E e) {
      Node<E> curr = head;
      boolean flag = false;
      while (curr != null){
         if(curr.equals(e)){
            flag = true;
            break;
         }
         curr = curr.next;
      }

      return flag;
   }

   @Override
   public void printList() {
      Node<E> temp = head;
      System.out.print("[");
      int i = 0;
      while (temp != null){
         if(i == size-1){
            System.out.print(temp.data);
         }else{
            System.out.print(temp.data+"->");
         }
         temp = temp.next;
         i++;
      }
      System.out.println("]");
   }

   public E get(int index){
      if(index < 0 || index >= size){
         throw new IndexOutOfBoundsException();
      }
      Node<E> temp = head;
      int i = 0;
      while (temp != null && i < index){ // move to required index
         temp = temp.next;
         i++;
      }

      if(i != index){
         throw new IndexOutOfBoundsException();
      }

      return temp.data;
   }
}
