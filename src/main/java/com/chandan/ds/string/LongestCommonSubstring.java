package com.chandan.ds.string;

import java.util.Scanner;

/**
 * Created by chandan on 27/9/18.
 * Ref : https://practice.geeksforgeeks.org/problems/longest-common-substring/0
 */
public class LongestCommonSubstring {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         sc.nextInt();
         sc.nextInt();
         String a = sc.next();
         String b = sc.next();
         int l = maxLengthSubstring(a, b);
         System.out.println(l);
      }
   }

   private static int maxLengthSubstring(String a, String b) {
      if (a == null || b == null) {
         return 0;
      }
      int n = a.length();
      int m = b.length();
      int max = 0;
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
         for (int j = 0; j <= m; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + 1;
               max = Math.max(max, dp[i][j]);
            }
         }
      }

      return max;
   }
}