package com.chandan.ds.trees;

/**
 * Created by chandan on 10/10/18.
 * https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
 */
public class NodesAtKDistanceFromGivenNode {
   public static void main(String[] args) {
      Node root = new Node(20);
      root.left = new Node(8);
      root.right = new Node(22);
      root.left.left = new Node(4);
      root.left.right = new Node(12);
      root.left.right.left = new Node(10);
      root.left.right.right = new Node(14);
      Node target = root.left.right;
      printkDistanceNode(root, target, 2);
   }

   private static int printkDistanceNode(Node root, Node target, int k) {
      if (root == null) {
         return -1;
      }
      if (root == target) { // root is the target, then printNodes At K distance below root
         printkDistanceNodeDown(root, k);
         return 0;
      }
      int ld = printkDistanceNode(root.left, target, k);
      if (ld != -1) { // target found in left subtree
         if (ld + 1 == k) { // root is at k distance, print it
            System.out.println(root.data + ", ");
         } else {
            printkDistanceNodeDown(root.right, k - ld - 2);
         }
         return ld + 1;
      }
      // target not found in left subtree
      int rd = printkDistanceNode(root.right, target, k);
      if (rd != -1) {
         if (rd + 1 == k) { // root is at k distance, print it
            System.out.println(root.data + ", ");
         } else {
            printkDistanceNodeDown(root.left, k - rd - 2);
         }
         return rd + 1;
      }
      // target not found

      return -1;
   }

   private static void printkDistanceNodeDown(Node root, int k) {
      if (root == null || k < 0) {
         return;
      }
      if (k == 0) { // distance is k now
         System.out.print(root.data + ", ");
         return;
      }
      printkDistanceNodeDown(root.left, k - 1);
      printkDistanceNodeDown(root.right, k - 1);
   }

   static class Node {
      int data;
      Node left, right;

      public Node(int data) {
         this.data = data;
      }
   }
}