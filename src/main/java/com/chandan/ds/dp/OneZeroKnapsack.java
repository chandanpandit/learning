package com.chandan.ds.dp;

/**
 * Created by chandan on 16/5/18.
 */
public class OneZeroKnapsack {
   public static void main(String[] args) {
      int val[] = {60, 100, 120};
      int wt[] = {10, 20, 30};
      int  W = 50;
      int n = val.length;
      System.out.println("Max Knapsack Value = "+knapsackRec(W,wt,val,n));
   }

   static int knapsackRec(int W, int[] wt, int[] val, int n) {
      if (W == 0 || n == 0) {
         return 0;
      }
      if ( wt[n-1] > W) // item can not be included
      {
         return knapsackRec(W, wt, val, n - 1);
      }
      return Math.max(val[n-1] + knapsackRec(W - wt[n-1], wt, val, n - 1), // item included or
                      knapsackRec(W, wt, val, n - 1) // item included
                     );
   }
}