package com.chandan.ds.trees;

import java.util.Stack;

/**
 * Created by chandan on 17/10/18.
 * Check if a given pre-order is valid for any BST
 */
public class ValidPreorder {
   public static void main(String[] args) {
      int[] a = {40, 30, 35, 20, 80, 100};
      int[] b = {45, 25, 15, 35, 75};
      int[] c = {50, 39, 44, 28, 85};
      int[] d = {10, 25, 5};
      int[] e = {30, 20, 10, 40, 50};

      System.out.println(isValid(a) + "|" + isValidImproved(a));
      System.out.println(isValid(b) + "|" + isValidImproved(b));
      System.out.println(isValid(c) + "|" + isValidImproved(c));
      System.out.println(isValid(d) + "|" + isValidImproved(d));
      System.out.println(isValid(e) + "|" + isValidImproved(e));

   }

   public static boolean isValid(int[] p) {
      return isValid(p, 0, p.length - 1);
   }

   /**
    * Validates by below algo
    * For each element of pre-order traversal, let j be the index at which an element greater than
    * current was found, return true if all conditions hold true:
    * i) All elements after j are greater than the current element
    * ii) same property holds true for i+1 to j-1 (left subtree) & j to n-1 (right subtree)
    * <p>
    * Thus we recursively check for validity of tree.
    *
    * @param p
    * @param start
    * @param end
    * @return
    */
   private static boolean isValid(int[] p, int start, int end) {
      if (start >= end) // base condition
      {
         return true;
      }
      int root = p[start];
      int j = start;
      while (j <= end) {
         if (p[j] > root) {
            break;
         }
         j++;
      }
      while (j <= end) { // all elements after j (ie right subtree)must be greater than root
         if (p[j] <= root) {
            return false;
         }
         j++;
      }

      // if we reach here the at this point is it valid. we need to validate left & right subtree
      return isValid(p, start + 1, j - 1) && isValid(p, j, end);
   }


   static boolean isValidImproved(int[] p) {
      Stack<Integer> stack = new Stack<>();
      int min = Integer.MIN_VALUE;
      for (int i = 0; i < p.length; i++) {
         int curr = p[i];
         if (curr < min) {
            return false;
         }
         while (!stack.isEmpty() && curr > stack.peek()) {
            min = stack.pop();
         }
         stack.add(curr);
      }
      return true;
   }
}
