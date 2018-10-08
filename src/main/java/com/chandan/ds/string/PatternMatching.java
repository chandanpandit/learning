package com.chandan.ds.string;

/**
 * Ref  : https://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 */
public class PatternMatching {
   public static void main(String[] args) {
      String text = "this is a test text. testing should always be done.";
      String pattern = "test";
      findPatterns(text, pattern);
   }

   private static void findPatterns(String text, String pattern) {
      int n = text.length();
      int m = pattern.length();
      for (int i = 0; i < n - m; i++) {
         int j = 0;
         while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
            j++;
         }
         if (j == m) {
            System.out.println("test found at index = " + i);
         }
      }
   }
}