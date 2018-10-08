package com.chandan.ds.dp.practice;

import java.util.Scanner;

public class SubsetSum {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();

      while (t > 0) {
         int n = sc.nextInt();
         int[] s = new int[n];
         for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
         }
         boolean flag = hasEqualSumSubset(s);
         System.out.println(flag ? "YES" : "NO");
         t--;
      }
   }

   private static boolean hasEqualSumSubset(int[] s) {
      int sum = 0;
      for (int i = 0; i < s.length; i++) {
         sum += s[i];
      }

      if (sum % 2 != 0) {
         return false;
      }

      int n = s.length;
      int S = sum / 2;

      boolean[][] dp = new boolean[S + 1][n];

      for (int i = 0; i < n; i++) {
         dp[0][i] = true;
      }

      for (int i = 1; i <= S; i++) {
         dp[i][0] = i == s[0];
         for (int j = 1; j < n; j++) {
            boolean x = (i - s[j]) >= 0 ? dp[i - s[j]][j-1] : false; // include
            boolean y = dp[i][j - 1]; // exclude
            dp[i][j] = x | y;
         }
      }

      return dp[S][n - 1];
   }
}