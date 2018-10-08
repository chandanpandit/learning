package com.chandan.ds.dp;

public class Ugly {
   public static void main(String[] args) {

      System.out.println(ugly(150));

   }
   static int ugly(int n){
      int[] ugly = new int[n];
      ugly[0] = 1;

      int i2 = 0;
      int i3 = 0;
      int i5 = 0;

      int nextMultiple2 = 2;
      int nextMultiple3 = 3;
      int nextMultiple5 = 5;

      int nextUgly = 1;

      for (int i = 1; i < n; i++) {
         nextUgly = Math.min(nextMultiple2,Math.min(nextMultiple3,nextMultiple5));
         ugly[i] = nextUgly;

         if(nextUgly == nextMultiple2){
            i2++;
            nextMultiple2 = ugly[i2] * 2;
         }
         if(nextUgly == nextMultiple3){
            i3++;
            nextMultiple3 = ugly[i3] * 3;
         }
         if(nextUgly == nextMultiple5){
            i5++;
            nextMultiple5 = ugly[i5] * 5;
         }
      }

      return nextUgly;
   }
}