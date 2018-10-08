package com.chandan.ds.linkedlist;


import java.util.Random;

public class LinkedListTest {
   public static void main(String[] args) throws Exception {
      LList a = new LList();
      LList b = new LList();
      Random random = new Random();
      for (int i = 0; i < 5; i++) {
         a.append(random.nextInt(10));
         b.append(random.nextInt(10));
      }
      a.mergeSort();
      b.mergeSort();
      a.printList();
      b.printList();
      LList c = LList.sortedIntersect(a, b);
      c.reverse();
      c.printList();
   }
}

class LList {
   Node head;

   static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   public void push(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
   }

   public void append(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         Node temp = head;
         while (temp.next != null) { // move to last node
            temp = temp.next;
         }
         temp.next = newNode;
      }
   }

   public void printList() {
      Node curr = head;
      while (curr != null) {
         System.out.print(curr.data + "->");
         curr = curr.next;
      }
      System.out.println("NULL");
   }

   public int count() {
      int count = 0;
      Node curr = head;
      while (curr != null) {
         count++;
         curr = curr.next;
      }

      return count;
   }

   /**
    * Returns ith element in list. Similar to a[i] if list were an array
    *
    * @param i index to be accessed
    * @return
    */
   public int getNth(int i) throws Exception {
      if (i < 0 || (i == 0 && head == null)) {
         throw new Exception("Index out of bounds : " + i);
      }
      Node curr = head;
      int j = 0;
      while (curr != null && j < i) {
         curr = curr.next;
         j++;
      }
      if (curr == null && j <= i) {
         throw new Exception("Index out of bounds : " + i);
      }

      return curr.data;
   }

   public void deleteList() {
      head = null;// rest of  nodes will be garbage collected
   }

   public int pop() throws Exception {
      if (head == null) {
         throw new Exception("List is empty!");
      }
      int data = head.data;
      head = head.next;
      return data;
   }

   // similar to a[i] = data
   public void insertNth(int data, int i) throws Exception {
      if (i < 0 || i > count()) {
         throw new Exception("Index out of bound : " + i);
      }
      Node newNode = new Node(data);
      if (i == 0) {
         newNode.next = head;
         head = newNode;
      } else {
         int j = 0;
         Node curr = head;
         while (j < i - 1) { // move to a position before the ith node
            curr = curr.next;
            j++;
         }
         newNode.next = curr.next;
         curr.next = newNode;
      }
   }

   /**
    * Assuming list to be sorted, it inserts data at its correct position
    */
   public void sortedInsert(int data) {
      Node newNode = new Node(data);
      sortedInsert(newNode);
   }

   /**
    * Assuming list to be sorted, it inserts Given node at its correct position
    */
   public void sortedInsert(Node newNode) {
      if (head == null) {
         head = newNode;
      } else if (newNode.data < head.data) { // insert at first position
         newNode.next = head;
         head = newNode;
      } else { // insert at correct position
         Node curr = head;
         while (curr.next != null && curr.next.data < newNode.data) { // move till before currNode should be placed
            curr = curr.next;
         }
         newNode.next = curr.next;
         curr.next = newNode;
      }
   }

   // sorts a linked list using insertion sort.
   // it uses sortedInsert to sort the list
   public void insertSort() {
      if (head == null || head.next == null) // empty list & size 1 list are always sorted
      {
         return;
      }
      Node curr = head.next; // 2nd node
      head.next = null;// detach first node
      while (curr != null) {
         Node temp = curr;
         curr = curr.next;
         temp.next = null;// detach temp node
         sortedInsert(temp);
      }
   }

   /**
    * Appends list b to this list
    *
    * @param b : another list's head
    */
   public void append(LList b) {
      if (b == null || b.head == null) {
         return;
      }
      if (head == null) {
         head = b.head;
      } else {
         Node curr = head;
         while (curr.next != null) {
            curr = curr.next;
         }
         curr.next = b.head;
      }
      b.head = null; // set b to null
   }

   /**
    * Splits list into two sub lists. If no of elements is odd, the first list will contain more elements
    *
    * @param front
    * @param back
    * @throws Exception
    */
   public void frontBackSplit(LList front, LList back) {
      if (front == null || back == null) {
         throw new EmptyListException("empty front/back list given");
      }
      if (head == null) {
         return;
      }
      Node fast = head, slow = head;
      while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      front.head = head;
      back.head = slow.next;
      slow.next = null;
      head = null;
   }

   public void removeDuplicatesFromSortedList() {
      if (head == null) {
         return;
      }
      Node curr = head;
      while (curr != null) {
         if (curr.next != null && curr.data == curr.next.data) {
            curr.next = curr.next.next;
         } else {
            curr = curr.next;
         }
      }
   }


   /**
    * Moves first node of second list to front of first list.
    *
    * @param source
    * @throws Exception
    */
   public void moveNode(LList source) throws Exception {
      if (source == null || source.head == null) {
         throw new Exception("Empty source list given");
      }
      Node temp = source.head;
      source.head = source.head.next;
      temp.next = head;
      head = temp;
   }

   // Gives a->b->c->d->e => {e->c->a} ,{d->b}
   // uses move node
   public void alternatingSplit(LList a, LList b) throws Exception {
      if (a == null || b == null) {
         throw new Exception("a/b cant be null");
      }
      while (head != null) {
         a.moveNode(this);
         if (head != null) {
            b.moveNode(this);
         }
      }
   }

   public static LList shuffleMerge(LList a, LList b) {
      LList c = new LList();
      c.head = new Node(0);
      Node tail = c.head;
      while (a != null && a.head != null && b != null && b.head != null) {
         tail = moveToTail(tail, a);
         tail = moveToTail(tail, b);
      }
      while (a != null && a.head != null) {
         tail = moveToTail(tail, a);
      }
      while (b != null && b.head != null) {
         tail = moveToTail(tail, b);
      }
      // remove dummy node
      c.head = c.head.next;

      return c;
   }

   /**
    * Moves first node of src to tail and returns new tail
    *
    * @param tail
    * @param src
    * @return tail of list
    */
   public static Node moveToTail(Node tail, LList src) {
      //detach first node
      Node temp = src.head;
      src.head = src.head.next;
      temp.next = null;
      if (tail != null) {
         tail.next = temp;
      }

      return temp;
   }

   public static Node sortedMerge(Node a, Node b) {
      if (a == null) {
         return b;
      }
      if (b == null) {
         return a;
      }
      Node result;
      if (a.data < b.data) {
         result = a;
         result.next = sortedMerge(a.next, b);
      } else {
         result = b;
         result.next = sortedMerge(a, b.next);
      }

      return result;
   }

   /**
    * Performs merge sort on current list
    */
   public void mergeSort() {
      if (head != null) {
         LList front = new LList();
         LList back = new LList();
         frontBackSplit(front, back);
         if (front.head != null && back.head != null && front.head != back.head) {
            // sort the two half
            front.mergeSort();
            back.mergeSort();
         }
         //merge the two sorted portion
         head = sortedMerge(front.head, back.head);
      }
   }

   public static LList sortedIntersect(LList a, LList b) {
      LList result = new LList();
      if (a == null || b == null) {
         return result;
      }
      Node aCurr = a.head, bCurr = b.head;
      while (aCurr != null && bCurr != null) {
         if (aCurr.data == bCurr.data) {
            result.push(aCurr.data);
            aCurr = aCurr.next;
            bCurr = bCurr.next;
         } else if (aCurr.data < bCurr.data) {
            aCurr = aCurr.next;
         } else {
            bCurr = bCurr.next;
         }
      }

      return result;
   }

   public void reverse() {
      head = reverse(head);
   }

   private Node reverse(Node head) {
      if (head == null) {
         return null;
      }
      Node curr = head;
      Node prev = null;
      Node next;
      while (curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      return prev;
   }

   //TODO recursive reverse
}

class EmptyListException extends RuntimeException {
   public EmptyListException(String message) {
      super(message);
   }
}

