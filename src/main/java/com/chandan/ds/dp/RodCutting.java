package com.chandan.ds.dp;

import java.util.Arrays;

/**
 * Created by chandan on 27/3/18.
 */
public class RodCutting {
   public static int cutRodRecc(int n,int[] p){
      if(n == 0) return 0;
      int max = Integer.MIN_VALUE;
      for (int i = 1; i <=n ; i++) {
         max = Math.max(max,p[i]+cutRodRecc(n-i,p));
      }
      return max;
   }
   public static int cutRod(int n,int[] p){
      int[] sol = new int[n+1];
      Arrays.fill(sol,Integer.MIN_VALUE);
      sol[0] = 0;
      return cutRod(n,p,sol);
   }
   private static int cutRod(int n,int[] p,int[] sol){
      if(sol[n] < 0){
         // build the solution
         int max = Integer.MIN_VALUE;
         for (int i = 1; i <=n ; i++) {
            max = Math.max(max,p[i]+cutRod(n-i,p,sol));
         }
         sol[n] = max;
      }
      return sol[n];
   }
   public static int cutRodBottomUp(int n,int[] p){
      int[] sol = new int[n+1];
      Arrays.fill(sol,Integer.MIN_VALUE);
      sol[0] = 0;
      for (int i = 1; i <= n; i++) {
         int max = Integer.MIN_VALUE;
         for (int j = 1; j <= i; j++) {
            max = Math.max(max,p[j]+sol[i-j]);
         }
         sol[i] = max;
      }
      return sol[n];
   }
   public static void cutRodPrintSol(int n,int[] p){
      int[] sol = new int[n+1];
      int[] cut = new int[n+1];
      Arrays.fill(sol,Integer.MIN_VALUE);
      sol[0] = 0;
      for (int i = 1; i <= n; i++) {
         int max = Integer.MIN_VALUE;
         for (int j = 1; j <= i; j++) {
            if(p[j]+sol[i-j] > max){
               max = p[j]+sol[i-j];
               cut[i] = j;
            }
         }
         sol[i] = max;
      }
      System.out.println("Max="+sol[n]);
      System.out.println("Cuts = ");
      while (n > 0){
         System.out.println(cut[n]);
         n = n - cut[n];
      }

   }
   public static void main(String[] args) {
      int[] p = {0,1,5,8,9,10,17,17,20,24,30,32,34,36,38,40,39,42,46,50,59,60,69,73};
      int n = 10;
      {
         long start = System.currentTimeMillis();
         int maxProfit = cutRodRecc(n, p);
         long end = System.currentTimeMillis();
         System.out.println(end - start);
         System.out.println(maxProfit);
      }
      {
         long start = System.currentTimeMillis();
         int maxProfit = cutRod(n, p);
         long end = System.currentTimeMillis();
         System.out.println(end-start);
         System.out.println(maxProfit);
      }
      {
         long start = System.currentTimeMillis();
         int maxProfit = cutRodBottomUp(n, p);
         long end = System.currentTimeMillis();
         System.out.println(end-start);
         System.out.println(maxProfit);
      }
      {
         long start = System.currentTimeMillis();
         cutRodPrintSol(n,p);
         long end = System.currentTimeMillis();
         System.out.println(end-start);
      }
   }
}