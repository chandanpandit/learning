package com.chandan.ds.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestDistinctCharacters {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String s = sc.next();
         int l = longestDistinctCharacters(s);
         System.out.println(l);
      }
   }

   static int longestDistinctCharacters(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      int max = 1;
      int n = s.length();
      for (int i = 0; i < n; i++) {
         Set<Character> set = new HashSet<>();
         for (int j = i; j < n; j++) {
            if (set.contains(s.charAt(j))) {
               break;
            } else {
               set.add(s.charAt(j));
            }
         }
         max = Math.max(max, set.size());
      }

      return max;
   }
}