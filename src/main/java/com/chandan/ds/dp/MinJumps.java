package com.chandan.ds.dp;

import java.util.Arrays;

public class MinJumps {
   public static void main(String[] args) {
      int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
      //int[] a = {1, 3, 6, 1, 0, 9};
      int[] dp = new int[a.length];
      Arrays.fill(dp, -1);

      System.out.println(minJumps(a, 0, dp));
   }

   static int minJumps(int[] a, int start, int[] dp) {
      if (start >= a.length) {
         return 0;
      }

      if (dp[start] >= 0) {
         return dp[start];
      }

      int jumps = Integer.MAX_VALUE;
      for (int i = 1; i <= a[start]; i++) {

         int temp = minJumps(a, start + i, dp);

         if (temp != Integer.MAX_VALUE) {
            jumps = Math.min(jumps, temp + 1);
         }
      }

      return dp[start] = jumps;
   }
}