package com.chandan.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chandan on 24/9/18.
 * Roman to decimal & decimal to roman conversions (upto 3999)
 */
public class RomanDecimalTest {
   public static void main(String[] args) throws Exception {

      for (int i = 1; i <= 3999; i++) {
         String roman = RomanUtils.convertToRoman(i);
         int decimal = RomanUtils.convertToDecimal(roman);
         System.out.println(i + " => " + roman);
         if (i != decimal) {
            throw new Exception("Test Failed for " + i);
         }
      }
   }
}

class RomanUtils {
   private static final String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
   private static final int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
   private static final Map<String, Integer> symbolToDecimalMap = new HashMap<>();

   static {
      for (int i = 0; i < symbols.length; i++) {
         symbolToDecimalMap.put(symbols[i], decimalValues[i]);
      }
   }

   /**
    * Scan char by char and
    * if curr char value is greater than or equal to the next char, add to total
    * else subtract this and add the next one.
    *
    * @param s
    * @return
    */
   public static int convertToDecimal(String s) {
      int total = 0;
      for (int i = 0; i < s.length(); i++) {
         int curr = symbolToDecimalMap.get(s.substring(i, i + 1));
         if (i + 1 < s.length()) {
            int next = symbolToDecimalMap.get(s.substring(i + 1, i + 2));
            if (curr < next) {
               total += next - curr;
               i++;
            } else {
               total += curr;
            }
         } else {
            total += curr;
         }
      }

      return total;
   }

   public static String convertToRoman(int num) {
      StringBuilder sb = new StringBuilder();
      while (num > 0) {
         for (int i = symbols.length - 1; i >= 0; i--) {
            if (num >= decimalValues[i]) {
               int n = num / decimalValues[i];
               for (int j = 0; j < n; j++) {
                  sb.append(symbols[i]);
               }
               num = num % decimalValues[i];
            }
         }
      }

      return sb.toString();
   }
}