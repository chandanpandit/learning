package com.chandan.ds.dp.practice;

import java.util.Arrays;
import java.util.Scanner;

public class PathInMatrix {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[][] a = new int[n][n];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               a[i][j] = sc.nextInt();
            }
         }
         System.out.println(maxPath(a, n));
      }
   }

   static int maxPath(int[][] a, int n) {
      int max = 0;
      int[][] dp = new int[n][n];
      for (int i = 0; i < n; i++) {
         Arrays.fill(dp[i],-1);
      }
      for (int i = 0; i < n; i++) {
         max = Math.max(max, maxPath(a, 0, i, n,dp));
         dp[0][i] = max;
      }

      return max;
   }

   private static int maxPath(int[][] a, int r, int c, int n, int[][] dp) {
      int max = 0;
      if (r < n ) {
         if(dp[r][c] >= 0)
            return dp[r][c];

         if (c > 0) {
            max = Math.max(max, a[r][c]+ maxPath(a, r + 1, c - 1, n, dp));
         }
         max = Math.max(max, a[r][c]+ maxPath(a, r + 1, c, n, dp));
         if (c < n - 1) {
            max = Math.max(max, a[r][c]+ maxPath(a, r + 1, c + 1, n, dp));
         }
         dp[r][c] = max;
      }

      return max;
   }
}