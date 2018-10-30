package com.chandan.ds.bitmagic;

/**
 * Created by chandan on 16/10/18.
 */
public class CountSetBits {
   public static void main(String[] args) {
      int n = -1992731921;
      PrintBits.printBits(n);
      System.out.println();
      System.out.println(countSetBitsPositive(n));
      System.out.println(countSetBits(n));
   }

   /**
    * works only for positive integers
    *
    * @param n
    * @return number of set bits
    */
   static int countSetBitsPositive(int n) {
      int count = 0;
      while (n > 0) {
         count += n & 1;
         n = n >> 1;
      }
      return count;
   }

   static int countSetBits(int n) {
      int count = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
         count += (n & mask) == 0 ? 0 : 1;
         mask = mask << 1;
      }

      return count;
   }
}