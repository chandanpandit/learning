package com.chandan.ds.trees;

import java.util.*;

public class TreeAllViews {
   public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);

      root.left.left = new Node(4);
      root.left.right = new Node(5);

      root.right.left = new Node(6);
      root.right.right = new Node(7);

      root.right.left.left = new Node(8);
      root.right.left.left.right = new Node(9);
      System.out.print("Left View :");
      printLeftView(root);
      System.out.print("\nRight View :");
      printRightView(root);
      System.out.print("\nTop View :");
      printTopView(root);
      System.out.print("\nBottom View :");
      printBottomView(root);
   }

   static void printLeftView(Node root) {
      if (root == null) {
         return;
      }
      Height hm = new Height();
      hm.max = -1;
      printLeftView(root, 0, hm);
   }

   static void printLeftView(Node root, int h, Height hm) {
      if (root == null) {
         return;
      }
      if (h > hm.max) {
         System.out.print(root.data + ", ");
         hm.max = h;
      }
      printLeftView(root.left, h + 1, hm);
      printLeftView(root.right, h + 1, hm);
   }

   static void printRightView(Node root) {
      if (root == null) {
         return;
      }
      Height hm = new Height();
      hm.max = -1;
      printRightView(root, 0, hm);
   }

   static void printRightView(Node root, int h, Height hm) {
      if (root == null) {
         return;
      }
      if (h > hm.max) {
         System.out.print(root.data + ", ");
         hm.max = h;
      }
      printRightView(root.right, h + 1, hm);
      printRightView(root.left, h + 1, hm);
   }

   static void printTopView(Node root) {
      if (root == null) {
         return;
      }
      Queue<QueueElement> queue = new LinkedList<>();
      queue.add(new QueueElement(root, 0));
      Map<Integer, Node> hdNodeMap = new HashMap<>();
      while (!queue.isEmpty()) {
         QueueElement elem = queue.poll();
         Node node = elem.node;
         int hd = elem.hd;
         if (!hdNodeMap.containsKey(hd)) { // the first node visited at each hd will be stored in map
            hdNodeMap.put(hd, node);
         }

         if (node.left != null) {
            queue.add(new QueueElement(node.left, hd - 1));
         }
         if (node.right != null) {
            queue.add(new QueueElement(node.right, hd + 1));
         }
      }

      // print in sorted hd order
      List<Integer> hdkeys = new ArrayList<>(hdNodeMap.keySet());
      Collections.sort(hdkeys);
      for (Integer key : hdkeys) {
         System.out.print(hdNodeMap.get(key).data + " ");
      }
   }

   // Idea is to visit on level order, and maintain the nodes vistied at
   // if two nodes are on the same hd and same height, then the last node visted in level order will be printed
   static void printBottomView(Node root) {
      if (root == null) {
         return;
      }
      Queue<QueueElement> queue = new LinkedList<>();
      Map<Integer, Node> hdNodeMap = new HashMap<>();
      queue.add(new QueueElement(root, 0));
      while (!queue.isEmpty()) {
         QueueElement elem = queue.poll();
         Node node = elem.node;
         int hd = elem.hd;
         hdNodeMap.put(hd, node); // final value will be last visited node for a horizontal distance
         if (node.left != null) {
            queue.add(new QueueElement(node.left, hd - 1));
         }
         if (node.right != null) {
            queue.add(new QueueElement(node.right, hd + 1));
         }
      }
      // print in sorted hd order
      List<Integer> hdkeys = new ArrayList<>(hdNodeMap.keySet());
      Collections.sort(hdkeys);
      for (Integer key : hdkeys) {
         System.out.print(hdNodeMap.get(key).data + " ");
      }
   }

   static class Node {
      int data;
      Node left;
      Node right;

      Node(int data) {
         this.data = data;
      }
   }

   static class Height {
      int max;
   }

   static class QueueElement {
      Node node;
      int hd;

      QueueElement(Node node, int hd) {
         this.node = node;
         this.hd = hd;
      }
   }
}