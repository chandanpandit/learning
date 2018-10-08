package com.chandan.ds.bitmagic;

/**
 * Created by chandan on 25/9/18.
 */
public class FindUnique {
   public static void main(String[] args) {
      int[] a = {3, 3, 2, 3};
      System.out.println(findSingleOccurrence(a));
   }

   static int findSingleOccurrence(int[] a) {
      int ones = 0, twos = 0, mask;
      for (int i = 0; i < a.length; i++) {
         twos |= ones & a[i];
         ones ^= a[i];
         mask = ~(ones & twos);
         twos &= mask;
         ones &= mask;
      }

      return ones;
   }
}