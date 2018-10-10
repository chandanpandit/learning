package com.chandan.ds.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by chandan on 10/10/18.
 * Ref : https://practice.geeksforgeeks.org/problems/rearrange-characters/0
 * Space Complexity : O(1) | Only lowercase alphabets allowed
 * Time Complexity :  O(nlog(26)) => O(n) | Only lowercase alphabets allowed
 */
public class RearrangeToRemoveDuplicateChars {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String s = sc.next();
         String result = rearrange(s);
         System.out.println(result);
         System.out.println(result == null ? 0 : 1);
      }
   }

   private static String rearrange(String s) {
      if (s == null || s.length() == 1) {
         return s;
      }
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
         Integer count = map.get(c);
         if (count == null) {
            count = 0;
         }
         map.put(c, count + 1);
      }

      PriorityQueue<CharCount> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
         queue.add(new CharCount(entry.getKey(), entry.getValue()));
      }

      StringBuilder sb = new StringBuilder(s.length());
      while (queue.size() > 1) {
         CharCount charCount = queue.poll();
         sb.append(charCount.c);
         charCount.count--;
         // Take out another element
         CharCount nextCharCount = queue.poll();
         sb.append(nextCharCount.c);
         nextCharCount.count--;

         if (charCount.count > 0) {
            queue.add(charCount);
         }
         if (nextCharCount.count > 0) {
            queue.add(nextCharCount);
         }
      }

      // At this point I should have either queue empty or only one element with one count
      if (queue.isEmpty() || (queue.size() == 1 && queue.peek().count == 1)) {
         return sb.toString();
      }

      return null;
   }

   static class CharCount {
      char c;
      int count;

      public CharCount(char c, int count) {
         this.c = c;
         this.count = count;
      }
   }
}