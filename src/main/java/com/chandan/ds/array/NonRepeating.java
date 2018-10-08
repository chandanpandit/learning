package com.chandan.ds.array;

import java.util.Scanner;

/**
 * Created by chandan on 14/9/18.
 */
public class NonRepeating {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         System.out.println(nonRepeatedBinarySearch(a));
      }
   }

   private static int nonRepeated(int[] a) {
      int number = 0;
      for (int i = 0; i < a.length; i++) {
         number = number ^ a[i];
      }

      return number;
   }

   private static int nonRepeatedBinarySearch(int[] a) {
      return nonRepeatedBinarySearch(a, 0, a.length - 1);
   }

   private static int nonRepeatedBinarySearch(int[] a, int low, int high) {
      if (low > high) {
         return -1;
      }
      if (low == high) {
         return a[low];
      }
      int mid = low + (high - low) / 2;
      if (mid % 2 == 0) { // even
         if (a[mid] == a[mid + 1]) {
            return nonRepeatedBinarySearch(a, mid + 2, high);// check in right of mid
         } else {
            return nonRepeatedBinarySearch(a, low, mid);
         }
      } else { // odd
         if (a[mid] == a[mid - 1]) {
            return nonRepeatedBinarySearch(a, mid + 1, high);
         } else {
            return nonRepeatedBinarySearch(a, low, mid - 1);
         }
      }
   }
}