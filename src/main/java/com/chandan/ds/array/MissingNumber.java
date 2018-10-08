package com.chandan.ds.array;

/**
 * Created by chandan on 30/3/18.
 */
public class MissingNumber {
   static int missingNum(int[] a){
      int x = 0;int k = 1;
      for (int i = 0; i < a.length; i++) {
         x ^= a[i];
         x ^= k++;
      }
      return x^k;
   }
   public static void main(String[] args) {
      int[] num = {9, 2, 3, 4, 1, 6, 7, 8, 10, 11};
      int x = missingNum(num);
      System.out.println(x);
   }
}