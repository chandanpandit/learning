package com.chandan.ds.trees;

public class MaxSumPath {

   public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(-2);
      root.right = new Node(7);
      root.left.left = new Node(8);
      root.left.right = new Node(-4);
      root.left.left.right = new Node(10);
      printMaxSumPath(root);
   }

   private static void printMaxSumPath(Node root) {
      if (root == null) {
         return;
      }
      Container target = new Container();
      int maxSum = maxSumPath(root, target);
      System.out.println("Max Sum = " + maxSum);
      System.out.println("Target Leaf ="+target.leaf.data);
      // print path from root to target Node
      printPathFromSrcToDest(root,target);
   }

   private static void printPathFromSrcToDest(Node root, Container target) {
      printPathFromSrcToDestRecc(root,target);
      System.out.println(target.leaf.data);
   }

   private static void printPathFromSrcToDestRecc(Node root, Container target) {
      if(root == null)
         return;
      //recurse down
      printPathFromSrcToDestRecc(root.left, target);
      printPathFromSrcToDestRecc(root.right, target);
      if(root.left == target.leaf){
         System.out.print(root.left.data + " <-");
         target.leaf = root;
      }else if(root.right == target.leaf){
         System.out.print(root.right.data + " <-");
         target.leaf = root;
      }
   }

   private static int maxSumPath(Node root, Container target) {
      // base cases
      if (root == null) {
         return 0;
      }
      if (root.left == null && root.right == null) {
         target.leaf = root;
         return root.data;
      }

      Container leftMaxLeaf = new Container();
      Container rightMaxLeaf = new Container();
      int leftMax = maxSumPath(root.left, leftMaxLeaf);
      int rightMax = maxSumPath(root.right, rightMaxLeaf);
      if (leftMax > rightMax) {
         target.leaf = leftMaxLeaf.leaf;
         return root.data + leftMax;
      } else {
         target.leaf = rightMaxLeaf.leaf;
         return root.data + rightMax;
      }
   }

   static class Node {
      int data;
      Node left, right;

      public Node(int data) {
         this.data = data;
      }
   }

   private static class Container {
      Node leaf;
   }
}