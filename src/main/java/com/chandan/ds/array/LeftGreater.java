package com.chandan.ds.array;

import com.chandan.ArrayUtils;

public class LeftGreater {
   public static void main(String[] args) {
      int[] a = {2, 5, 1, 6, 4, 7}; // 4 -> 5-4
      int[] b = {5, 2, 1, 9, 8, 7, 15, 16}; // 3 -> 5-1 or 9-7
      int[] c = {1}; // 0
      int[] d = {1, 2, 3}; // 0
      int[] e = {4, 3, 2, 1}; // 4
      int[] f = {7, 9, 8, 4, 3, 12, 11}; // 5 -> 7-3
      int[] h = {1, 2, 5, 7, 3, 10, 9, 4, 6};
      System.out.println(leftGreater(a));
      System.out.println(leftGreater(b));
      System.out.println(leftGreater(c));
      System.out.println(leftGreater(d));
      System.out.println(leftGreater(e));
      System.out.println(leftGreater(f));
      System.out.println(leftGreater(h));
   }

   static int leftGreater(int[] a) {
      int n = a.length;

      if (n <= 1) {
         return 0; // atlest two elements are required
      }

      int[] rightMin = new int[n];
      int[] leftMax = new int[n];

      leftMax[0] = a[0];
      for (int i = 1; i < n; i++) {
         leftMax[i] = Math.max(a[i], leftMax[i - 1]);
      }

      rightMin[n - 1] = a[n - 1];
      for (int i = n - 2; i >= 0; i--) {
         rightMin[i] = Math.min(a[i], rightMin[i + 1]);
      }

      ArrayUtils.printArray("Original",a);
      ArrayUtils.printArray("Left Max",leftMax);
      ArrayUtils.printArray("Right Min",rightMin);

      int i = 0, j = 0;
      int len = 0;
      while (i < n && j < n) {
         while (j < n && rightMin[j] < leftMax[i]) {
            j++;
         }
         len = Math.max(len,j-i);
         i++;
      }

      return len;
   }
}