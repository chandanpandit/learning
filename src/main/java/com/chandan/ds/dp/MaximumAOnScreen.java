package com.chandan.ds.dp;

import java.util.Scanner;

/**
 * Created by chandan on 6/10/18.
 * Ref : https://practice.geeksforgeeks.org/problems/special-keyboard/0
 */
public class MaximumAOnScreen {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- >0){
         int n = sc.nextInt();
         System.out.println(countMaxABottomUp(n));
      }
   }

   private static int countMaxA(int n) {
      if (n <= 6) {
         return n;
      }
      int max = Integer.MIN_VALUE;
      for (int i = n - 3; i >= 1; i--) {
         int curr = countMaxA(i) * (n - i - 1);
         max = Math.max(max, curr);
      }

      return max;
   }

   private static int countMaxABottomUp(int n) {
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
         if (i <= 6) {
            dp[i] = i;
         } else {
            int max = Integer.MIN_VALUE;
            for (int j = i - 3; j >= 1; j--) {
               int curr = dp[j] * (i - j - 1);
               max = Math.max(max, curr);
            }
            dp[i] = max;
         }
      }

      return dp[n];
   }
}