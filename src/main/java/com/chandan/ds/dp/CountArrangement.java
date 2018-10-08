package com.chandan.ds.dp;

/*
* a -> 0
* e -> 1
* i -> 2
* o -> 3
* u -> 4
* */

import java.util.Arrays;

public class CountArrangement {
   public static void main(String[] args) {
      int n = 3;
      int[][] dp = new int[n + 1][5];

      for (int i = 0; i <= n; i++) {
         Arrays.fill(dp[i], -1);
      }

      int count = count(0, n, dp);
      System.out.println(count);
   }

   static int count(int lastChar, int remainingLength, int[][] dp) {
      int total = 0;

      if (remainingLength <= 1) {
         total = 5 - lastChar;
         dp[remainingLength][lastChar] = total;

         return total;
      }

      if (dp[remainingLength][lastChar] >= 0) {
         return dp[remainingLength][lastChar];
      }

      for (int i = lastChar; i < 5; i++) {
         total += count(i, remainingLength - 1, dp);
      }

      dp[remainingLength][lastChar] = total;

      return total;
   }
}