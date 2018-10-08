package com.chandan.ds.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Largest Number formed from an Array
 * Ref : https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
 * Time Complexity : O(nlogn)
 * Space Complexity : O(1)
 */
public class LargestNumberFormedFromArray {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         Integer[] a = new Integer[n];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         System.out.println(getLargestNumberFormedFromArray(a));
      }
   }

   private static String getLargestNumberFormedFromArray(Integer[] a) {
      Arrays.sort(a, (n1, n2) -> {
         String result1 = Integer.toString(n1) + Integer.toString(n2);
         String result2 = Integer.toString(n2) + Integer.toString(n1);
         if (Integer.parseInt(result1) > Integer.parseInt(result2)) {
            return -1;
         } else {
            return 1;
         }
      });

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < a.length; i++) {
         sb.append(a[i]);
      }

      return sb.toString();
   }
}