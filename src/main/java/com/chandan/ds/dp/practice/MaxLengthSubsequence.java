package com.chandan.ds.dp.practice;

import java.util.Arrays;

public class MaxLengthSubsequence {
   public static void main(String[] args) {
      //int[] a = {2, 5, 6, 3, 7, 6, 5, 8};
      int[] a = {-2, -1, 5, -1, 4, 0, 3};
      int len = maxLength(a);
      System.out.println(len);
   }

   private static int maxLength(int[] a) {
      int n = a.length;
      int[] dp = new int[n];
      Arrays.fill(dp,1); // 1 length\
      int[] parent = new int[n];
      Arrays.fill(parent,-1);
      for (int i = 1; i < n ; i++) {
         for (int j = 0; j < i; j++) {
            if(Math.abs(a[i]-a[j]) <= 1 && dp[i] < dp[j]+1){
               dp[i] = dp[j] + 1;
               parent[i] = j;
            }
         }
      }

      int max = 0;
      int start = -1;
      for (int i = 0; i < n; i++) {
         if(dp[i] > max){
            max = dp[i];
            start = i;
         }
      }

      while (start != -1){
         System.out.print(a[start] + ", ");
         start = parent[start];
      }
      System.out.println();

      return max;
   }
}