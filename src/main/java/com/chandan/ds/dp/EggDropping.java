package com.chandan.ds.dp;

import java.util.Scanner;

/**
 * Created by chandan on 23/9/18.
 * Ref :
 */
public class EggDropping {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int k = sc.nextInt();
         System.out.println(drop(n, k));
         System.out.println(dropBottomUp(n, k));
      }
   }

   private static int drop(int n, int k) {
      if (k <= 1) {
         return k;
      }
      if (n == 1) {
         return k;
      }

      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= k; i++) {
         int attempts = Math.max(drop(n - 1, i - 1), drop(n, k - i));
         if (attempts < min) {
            min = attempts;
         }
      }

      return min + 1;
   }

   private static int dropBottomUp(int n, int k) {
      int[][] dp = new int[k + 1][n + 1];

      for (int i = 0; i <= k; i++) {
         for (int j = 0; j <= n; j++) {
            if (j == 0) {
               dp[i][j] = 0;
            } else if (i == 0 || j == 1) {
               dp[i][j] = i;
            } else {
               int min = Integer.MAX_VALUE;
               for (int l = 1; l <= i; l++) {
                  int value = Math.max(dp[l - 1][j - 1], dp[i - l][j]);
                  if (value < min) {
                     min = value;
                  }
               }
               dp[i][j] = 1 + min;
            }
         }
      }

      return dp[k][n];
   }
}