package com.chandan.ds.array;


import java.util.Arrays;

public class RemoveDuplicates {
   public static void main(String[] args) {
      int[] a = {1, 2, 3, 4, 5, 5, 5};
      makeDistinctBaba(a);
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + ", ");
      }
   }

   static void makeDistinct(int[] a) {
      Arrays.sort(a);
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] >= a[i + 1]) {
            a[i + 1] = a[i + 1] + 1;
         }
      }
   }

   static void makeDistinctBaba(int[] arr) {
      Arrays.sort(arr);
      int n = arr.length;
      int temp = 0;
      int flag = 0;
      for (int i = 1; i < n; i++) {
         if (arr[i] == arr[i - 1]) {
            temp = arr[i];
            flag = 1;
         } else if (arr[i] < arr[i - 1]) {
            arr[i] = arr[i - 1] + 1;
         }
         while (i < n && arr[i] == temp) {
            arr[i] = arr[i - 1] + 1;
            i++;
         }
         if (flag == 1) {
            i--;
            flag = 0;
         }
      }
   }
}