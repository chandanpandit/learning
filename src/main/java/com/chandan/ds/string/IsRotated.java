package com.chandan.ds.string;

import java.util.Scanner;

/**
 * Created by chandan on 27/9/18.
 * https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
 */
public class IsRotated {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String a = sc.next();
         String b = sc.next();
         boolean result = isRotatedByTwo(a, b);
         System.out.println(result ? "1" : "0");
      }
   }

   static boolean isRotatedByTwo(String a, String b) {
      int n = a.length();
      int m = b.length();
      if (n != m) {
         return false;
      }
      String c = a + a;
      int i = 2, j = 0;
      while (j < n && c.charAt(i) == b.charAt(j)) {
         i++;
         j++;
      }
      if (j == n) {
         return true;
      }

      i = n - 2;
      j = 0;
      while (j < n && c.charAt(i) == b.charAt(j)) {
         i++;
         j++;
      }
      if (j == n) {
         return true;
      }

      return false;

   }

}