package com.chandan.ds.array;

import java.util.*;

public class RelativeSorting {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int m = sc.nextInt();
         int n = sc.nextInt();
         Integer[] A1 = new Integer[m];
         int[] A2 = new int[n];
         for (int i = 0; i < m; i++) {
            A1[i] = sc.nextInt();
         }
         for (int i = 0; i < n; i++) {
            A2[i] = sc.nextInt();
         }
         Arrays.sort(A1, new CustomComparator(A2));
         for (int i = 0; i < m; i++) {
            System.out.print(A1[i]+" ");
         }
         System.out.println();
      }
   }

   static class CustomComparator implements Comparator<Integer> {
      private int[] ref; // reference array for sorting
      private Map<Integer, Integer> map = new HashMap<>();

      public CustomComparator(int[] ref) {
         this.ref = ref;
         for (int i = 0; i < ref.length; i++) {
            map.put(ref[i], i);
         }
      }

      @Override
      public int compare(Integer o1, Integer o2) {
         if (map.containsKey(o1) && map.containsKey(o2)) {
            return map.get(o1) > map.get(o2) ? 1 : -1;
         } else if (map.containsKey(o1)) {
            return -1;
         } else if (map.containsKey(o2)) {
            return 1;
         } else {
            return o1 > o2 ? 1 : -1;
         }
      }
   }
}