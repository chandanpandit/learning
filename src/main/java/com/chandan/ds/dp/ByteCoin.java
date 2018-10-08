package com.chandan.ds.dp;

/**
 * Created by chandan on 15/11/17.
 */
public class ByteCoin {
   private static int[] maxTable = new int[100];
   public static int maximize(int n){
      if(n <= 0)
         return 0;
      if(maxTable[n] == 0){
         int amount =  maximize(n/2) + maximize(n/3) + maximize(n/4);
         if(amount > n)
            maxTable[n] = amount;
         else
            maxTable[n] = n;
      }

      return maxTable[n];
   }
   public static void main(String[] args) {
      int n = 13;
      System.out.println(maximize(n));
   }
}
