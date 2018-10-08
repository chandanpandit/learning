package com.chandan.ds.array;

/**
 * Created by chandan on 5/10/18.
 */
public class MaximumAreaInHistogram {
   public static void main(String[] args) {
      int[] a = {6, 2, 5, 4, 5, 1, 6};
      int maxArea = findMaxArea(a);
      System.out.println(maxArea);
   }

   private static int findMaxArea(int[] a) {
      int n = a.length;
      int maxArea = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
         int count = 0;
         int j = i - 1;
         while (j >= 0 && a[j] >= a[i]) {
            count++;
            j--;
         }
         j = i;
         while (j < n && a[j] >= a[i]) {
            count++;
            j++;
         }
         int currArea = a[i] * count;
         if (currArea > maxArea) {
            maxArea = currArea;
         }
      }
      return maxArea;
   }
}