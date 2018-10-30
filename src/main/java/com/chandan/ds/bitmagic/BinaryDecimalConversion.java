package com.chandan.ds.bitmagic;

public class BinaryDecimalConversion {
   public static void main(String[] args) {
      int n = 1023;
      String bin = "1001";
      System.out.println("Decimal To Binary = " + decimalToBin(n));
      System.out.println("Binary To Decimal = " + binToDecimal(bin));

   }

   private static int binToDecimal(String bin) {
      int number = 0;
      int mask = 1;
      for (int i = bin.length() - 1; i >= 0; i--) {
         if (bin.charAt(i) == '1') {
            number += mask;
         }
         mask = mask << 1;
      }
      return number;
   }

   private static String decimalToBin(int n) {
      return null;
   }


}