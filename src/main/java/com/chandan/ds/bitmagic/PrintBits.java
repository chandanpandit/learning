package com.chandan.ds.bitmagic;

/**
 * Created by chandan on 25/9/18.
 */
public class PrintBits {

   public static void main(String[] args) {
      /*for (int i = 0; i < 50; i++) {
         System.out.print(i + "  => \t");
         printBits(i);
         System.out.println();
      }*/

      printBits(-3);
   }

   static void printBits(int n) {
      for (int i = 31; i >= 0; i--) {
         int mask = 1 << i;
         if ((mask & n) == 0) {
            System.out.print("0");
         } else {
            System.out.print("1");
         }
      }
   }
}
