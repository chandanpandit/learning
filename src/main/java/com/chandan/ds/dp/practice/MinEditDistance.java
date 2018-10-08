package com.chandan.ds.dp.practice;

import java.util.Scanner;

public class MinEditDistance {
   private static final int INSERT = 1;
   private static final int DELETE = 1;
   private static final int REPLACE = 1;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0) {
         sc.nextInt();
         sc.nextInt();
         String a = sc.next();
         String b = sc.next();
         sc.nextLine();
         System.out.println(minEditDistance(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
         t--;
      }
   }

   static int minEditDistanceRecc(char[] s1, char[] s2, int m, int n) {
      if (m == 0) {
         return n;
      }
      if (n == 0) {
         return m;
      }
      if (s1[m - 1] == s2[n - 1]) {
         return minEditDistanceRecc(s1, s2, m - 1, n - 1);
      }
      return Math.min(REPLACE + minEditDistanceRecc(s1, s2, m - 1, n - 1), // replace
                      Math.min(DELETE + minEditDistanceRecc(s1, s2, m - 1, n), // delete
                                   INSERT + minEditDistanceRecc(s1, s2, m, n - 1)));// insert
   }

   static int  editDistance(String s1, String s2){
      if(s1.length() == 0 && s2.length() == 0) return 0;
      if(s1 == "") return s2.length() * INSERT;
      if(s2.length() ==0) return s1.length() * DELETE;

      if(s1.charAt(s1.length()-1) == s2.charAt(s2.length())){
         return editDistance(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
      }
      return Math.min(editDistance(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1)) + REPLACE,
                      Math.min(editDistance(s1.substring(0, s1.length()), s2.substring(0, s2.length() - 1)) + INSERT,
                      editDistance(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()))) + DELETE
                      );
   }

   static int minEditDistance(char[] s1, char[] s2, int m, int n) {
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
         for (int j = 0; j <= m; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = Math.max(i, j);
            } else if (s2[i-1] == s1[j-1]) { // both are same chars
               dp[i][j] = dp[i - 1][j - 1]; // no cost
            } else {
               dp[i][j] = Math.min(REPLACE + dp[i - 1][j - 1], // repace
                                   Math.min(INSERT + dp[i][j - 1], // insert
                                            DELETE + dp[i - 1][j])); // delete
            }
         }
      }

      return dp[n][m];
   }
}