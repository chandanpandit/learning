package com.chandan.ds.linkedlist;

public class ReverseWordsInLinkedList {

   private static final char SPACE = '_';

   public static void main(String[] args) {
      String input = "MY_NAME_IS_CHANDAN_PANDIT";
      Node head = null;
      for (char c : input.toCharArray()) {
         head = append(head, c);
      }
      System.out.println("Before :");
      print(head);
      head = reverse(head);
      System.out.println("After :");
      print(head);
   }

   private static Node reverse(Node head) {
      Node prev = null;
      Node currStart = head;
      Node currEnd = getCurrentEnd(head);
      Node next;
      while (currEnd != null) {
         next = currEnd.next;
         currEnd.next = prev;
         prev = currStart;
         if (next != null) { // append space node to prev
            Node temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
         }
         currStart = next;
         currEnd = getCurrentEnd(next);

      }
      return prev;
   }

   private static Node getCurrentEnd(Node curr) {
      if (curr == null) {
         return null;
      }
      while (curr.next != null && curr.next.data != SPACE) {
         curr = curr.next;
      }
      return curr;
   }

   static Node append(Node head, char c) {
      Node newNode = new Node(c);
      if (head == null) {
         head = newNode;
      } else {
         Node curr = head;
         while (curr.next != null) {
            curr = curr.next;
         }
         curr.next = newNode;
      }

      return head;
   }

   static void print(Node head) {
      while (head != null) {
         System.out.print(head.data + "->");
         head = head.next;
      }
      System.out.println("NULL");
   }

   static class Node {
      char data;
      Node next;

      public Node(char data) {
         this.data = data;
      }
   }
}