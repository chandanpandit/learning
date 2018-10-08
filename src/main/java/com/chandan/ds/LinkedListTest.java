package com.chandan.ds;

import com.chandan.ds.linkedlist.LinkedList;
import com.chandan.ds.linkedlist.MySLLinkedList;

public class LinkedListTest {
   public static void main(String[] args) {
      LinkedList<Integer> mylist = new MySLLinkedList<>();
      //System.out.println(mylist.isEmpty()); true
      for (int i = 0; i < 5; i++) {
         mylist.add(i);
      }
      //mylist.printList();//[0->1->2->3->4]
      mylist.add(5);
      mylist.remove(3);
      mylist.remove(0);
      mylist.printList();
      System.out.println(mylist.get(1));

      System.out.println(mylist.contains(-1));
      System.out.println(mylist.contains(2));
      System.out.println(mylist.contains(5));
      System.out.println(mylist.contains(3));
   }
}
