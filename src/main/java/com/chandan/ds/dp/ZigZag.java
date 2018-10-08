package com.chandan.ds.dp;

import java.util.Arrays;

public class ZigZag {
   static int maxZigZabLength(int[] a){
      int n = a.length;
      int[] up = new int[n];
      int[] down = new int[n];
      Arrays.fill(up,1);
      Arrays.fill(down,1);
      for (int i = 1; i < n; i++) {
         for (int j = 0; j < i; j++) {
            if(a[i] > a[j]){
               up[i] = Math.max(down[j]+1,up[i]);
            }else{
               down[i] = Math.max(up[j]+1,down[i]);
            }
         }
      }
      int maxLength = 0;
      for (int i = 0; i < n; i++) {
         maxLength = Math.max(maxLength,up[i]);
         maxLength = Math.max(maxLength,down[i]);
      }

      return maxLength;
   }
   public static void main(String[] args) {
      int[] a = {3,9,12,8,7,13,5};
      System.out.println(maxZigZabLength(a));
   }
}
