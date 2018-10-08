package com.chandan.ds.dp.practice;

import java.util.Scanner;

public class CoinChange {
   public static void main(String[] args) {
      /*int[] s = {2, 5, 3, 6};
      int n = 10;*/

      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0){
         int m = sc.nextInt();
         int[] s = new int[m];
         for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
         }
         int n = sc.nextInt();
         System.out.println(countChange(s, n));
         t--;
      }
   }

   public static int countChange(int[] s,int n){
      int m = s.length;
      int[][] dp = new int[n+1][m];
      for (int j = 0; j < m; j++) {
         dp[0][j] = 1;
      }
      for (int i = 1; i <= n; i++) {
         for (int j = 0; j < m; j++) {
            int x = (i - s[j]) >= 0 ? dp[i - s[j]][j] : 0; // include coin s[j]
            int y = j >= 1 ? dp[i][j-1] : 0; // exclude coin s[j]
            dp[i][j] = x + y;
         }
      }

      return dp[n][m-1];
   }

   public static int count( int S[], int m, int n )
   {
      // table[i] will be storing the number of solutions for
      // value i. We need n+1 rows as the table is constructed
      // in bottom up manner using the base case (n = 0)
      int table[]=new int[n+1];

      // Base case (If given value is 0)
      table[0] = 1;

      // Pick all coins one by one and update the table[] values
      // after the index greater than or equal to the value of the
      // picked coin

      //m = s.length

      for(int i=0; i<m; i++) // pick coin one by one
         for(int j=S[i]; j<=n; j++)
            table[j] += table[j-S[i]];

      for (int i = 0; i <= n; i++) {
         System.out.println(i+" = "+table[i]);
      }

      return table[n];
   }

}