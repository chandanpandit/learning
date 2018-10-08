package com.chandan.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Sorting Elements of an Array by Frequency
 * Ref : https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
 * Time Complexity :O(n + m Log m)  | where m is number of distinct elements
 * Space Complexity : O(m) | where m is number of distinct elements
 */
public class SortByFrequency {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         sortByFrequency(a);
         for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
         }
         System.out.println();
      }
   }

   private static void sortByFrequency(int[] a) {
      Map<Integer, Integer> counts = new HashMap<>();
      for (int i = 0; i < a.length; i++) {
         int count = 0;
         if (counts.containsKey(a[i])) {
            count = counts.get(a[i]);
         }
         counts.put(a[i], count + 1);
      }
      Pair[] pairs = new Pair[counts.size()];
      int i = 0;
      for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
         pairs[i++] = new Pair(entry.getValue(), entry.getKey());
      }
      Arrays.sort(pairs, (x, y) -> {
         if (x.count == y.count) {
            return x.num < y.num ? -1 : 1;
         } else {
            return x.count > y.count ? -1 : 1;
         }
      });
      // we have pairs sorted by count and if counts are equal we have smaller number first
      int k = 0;
      for (int j = 0; j < pairs.length; j++) {
         while (pairs[j].count-- > 0) {
            a[k++] = pairs[j].num;
         }
      }
   }

   static class Pair {
      int count;
      int num;

      public Pair(int count, int num) {
         this.count = count;
         this.num = num;
      }
   }
}