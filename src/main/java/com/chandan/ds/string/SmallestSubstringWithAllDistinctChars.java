package com.chandan.ds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/length-smallest-sub-string-consisting-maximum-distinct-characters/
 */
public class SmallestSubstringWithAllDistinctChars {
   public static void main(String[] args) {
      //String s = "AABBBCBBAC";
      //String s = "AABBBCBB";
      String s = "GEEKSGEEKSFOR";
      int c = solve(s);
      System.out.println(c);
   }

   private static int solve(String s) {
      int n = s.length();
      int min = Integer.MAX_VALUE;
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
         set.add(s.charAt(i));
      }
      for (int i = 0; i < n - 1; i++) {
         for (int j = i + 1; j < n; j++) {
            Set<Character> another = new HashSet<>();
            for (int k = i; k <= j; k++) {
               another.add(s.charAt(k));
            }
            if (another.size() == set.size()) {
               min = Math.min(min, j - i + 1);
            }
         }
      }

      return min;
   }
}