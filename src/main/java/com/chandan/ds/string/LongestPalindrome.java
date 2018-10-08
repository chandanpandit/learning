package com.chandan.ds.string;

import java.util.Scanner;

public class LongestPalindrome {
   private static int counter = 0;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String input = sc.next();
         System.out.println(longestPalindrome(input));
         System.out.println("Counter="+counter+"|"+input.length());
      }
   }

   private static String longestPalindrome(String input) {
      if (input.length() <= 1) {
         return input;
      }

      Pair result = new Pair(0, 0, 1);
      for (int i = 0; i < input.length() - 1; i++) {
         maximizeLongestPalindrome(input, i, i, result);
         maximizeLongestPalindrome(input, i, i + 1, result);
      }

      return input.substring(result.s, result.e + 1); // end index is exclusive
   }

   private static void maximizeLongestPalindrome(String input, int i, int j, Pair result) {
      while (i >= 0 && j < input.length() && input.charAt(i) == input.charAt(j)) {
         counter++;
         if ((j - i + 1) > result.l) {
            result.l = j - i + 1;
            result.s = i;
            result.e = j;
         }
         i--;
         j++;
      }
   }

   static class Pair {
      int s, e, l;// start, end

      public Pair(int s, int e, int l) {
         this.s = s;
         this.e = e;
         this.l = l;
      }
   }
}