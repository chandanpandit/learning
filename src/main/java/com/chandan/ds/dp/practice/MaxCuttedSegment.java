package com.chandan.ds.dp.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MaxCuttedSegment {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int x = sc.nextInt();
         int y = sc.nextInt();
         int z = sc.nextInt();
         System.out.println(maximize(n,x,y,z));
      }
   }

   static int maximize(int n, int x, int y, int z) {
      int[] dp = new int[n+1];
      Arrays.fill(dp,-1);
      dp[0] = 0;
      int min = Math.min(x,Math.min(y,z));
      for (int i = min; i <= n ; i++) {
         if(i >= x && dp[i-x] != -1){
            dp[i] = Math.max(dp[i],dp[i-x]+1);
         }
         if(i >= y && dp[i-y] != -1){
            dp[i] = Math.max(dp[i],dp[i-y]+1);
         }
         if(i >= z && dp[i-z] != -1){
            dp[i] = Math.max(dp[i],dp[i-z]+1);
         }
      }

      return dp[n];
   }
}