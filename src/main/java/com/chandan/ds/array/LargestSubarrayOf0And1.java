package com.chandan.ds.array;

import java.util.Scanner;

/**
 * Largest subarray of 0's and 1's
 * Ref : https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class LargestSubarrayOf0And1 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         System.out.println(largestSubArray01(a));
      }
   }

   private static int largestSubArray01(int[] arr) {
      int c0 = 0, c1 = 0, i = 0, j = arr.length - 1;
      for (int k = 0; k < arr.length; k++) {
         if (arr[k] == 0) {
            c0++;
         } else {
            c1++;
         }
      }

      while (i < j) {
         if (c0 == c1) {
            break;
         } else if (c0 > c1) { // remove extra 0
            if (arr[i] == 0) {
               i++;
               c0--;
            } else if (arr[j] == 0) {
               j--;
               c0--;
            } else { // remove 1 from any side
               i++;
               c1--;
            }
         } else {
            if (arr[i] == 1) {
               i++;
               c1--;
            } else if (arr[j] == 1) {
               j--;
               c1--;
            } else {
               i++;
               c0--;
            }
         }
      }


      return (j - i) > 0 ? (j - i) + 1 : 0;
   }
}
