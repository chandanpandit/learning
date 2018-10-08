package com.chandan.ds.trees;

import java.util.HashMap;
import java.util.Map;

public class VerticalSum {
   static class Node{
      int data;
      Node left,right;

      public Node(int data) {
         this.data = data;
      }
   }

   public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);
      Map<Integer,Integer> horizontalSum = new HashMap<>();
      findHorizontalSum(root,0,horizontalSum);
      /*for (Map.Entry<Integer,Integer> entry : horizontalSum.entrySet()){
         System.out.println(entry.getKey()+"="+entry.getValue());
      }*/
      System.out.println(horizontalSum.entrySet());
   }

   private static void findHorizontalSum(Node root, int hd, Map<Integer, Integer> horizontalSum) {
      if(root == null)
         return;
      int original = 0;
      if(horizontalSum.containsKey(hd)){
         original = horizontalSum.get(hd);
      }
      horizontalSum.put(hd,original+root.data);
      findHorizontalSum(root.left,hd-1,horizontalSum);
      findHorizontalSum(root.right,hd+1,horizontalSum);
   }
}
