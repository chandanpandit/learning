package com.chandan.ds.dp;

import com.chandan.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ref : https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence/0
 */
public class LongestBitonicSubsequence {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         int l = longestBitonicSubsequence(a);
         System.out.println(l);
      }
   }

   private static int longestBitonicSubsequence(int[] a) {
      int n = a.length;
      int[] lis = new int[n];
      Arrays.fill(lis, 1);
      for (int i = 1; i < n; i++) {
         for (int j = 0; j < i; j++) {
            if (a[i] > a[j]) {
               lis[i] = Math.max(lis[i], lis[j] + 1);
            }
         }
      }

      int[] lds = new int[n];
      Arrays.fill(lds, 1);
      for (int i = n - 2; i >= 0; i--) {
         for (int j = n - 1; j > i; j--) {
            if (a[i] > a[j]) {
               lds[i] = Math.max(lds[i], lds[j] + 1);
            }
         }
      }

      ArrayUtils.printArray("lis", lis);
      ArrayUtils.printArray("lds", lds);
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
         max = Math.max(max, lis[i] + lds[i] - 1);
      }

      return max;
   }
}