package com.chandan.ds.dp.practice;

import java.util.Scanner;

public class CountNumberOfSteps {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] dp = new int[n+1];
         dp[0] = 0;
         System.out.println(count(n, dp));
      }
   }

   private static int count(int n, int[] dp) {
      if (n <= 0) {
         return 0;
      }
      if (dp[n] > 0) {
         return dp[n];
      }
      if(n == 1)
         return dp[1] = 1;
      if(n == 2)
         return dp[2] = 2;
      if(n == 3)
         return dp[3] = 4;
      return dp[n] = count(n - 1, dp) + count(n - 2, dp) + count(n - 3, dp);
   }
}