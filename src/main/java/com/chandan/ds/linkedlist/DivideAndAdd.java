package com.chandan.ds.linkedlist;

public class DivideAndAdd {
   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      int size = 5;
      for (int i = 1; i <= size; i++) {
         list.add(i);
      }
      System.out.println("Before :: ");
      list.print();
      divideAndAdd(list, size);
      System.out.println("After :: ");
      list.print();
   }

   public static void divideAndAdd(LinkedList list, int size) {
      divideAndAdd(list.root, list.root, 1, size);
   }

   public static Node divideAndAdd(Node root, Node curr, int l, int n) {
      if (l < (n + 1) / 2) {
         curr = divideAndAdd(root.next, curr.next, l + 1, n);
      }
      if (n % 2 == 0 && l == n / 2) {
         curr = curr.next;
      }
      curr.data = curr.data + root.data;
      return curr.next;
   }

   static class LinkedList {
      Node root;

      public LinkedList() {
         root = null;
      }

      public void add(int data) {
         Node node = new Node(data);
         if (root == null) {
            root = node;
         } else {
            Node temp = root;
            while (temp.next != null) {
               temp = temp.next;
            }
            temp.next = node;
         }
      }

      public void print() {
         Node temp = root;
         while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
         }
         System.out.println("NULL");
      }
   }

   static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }
}