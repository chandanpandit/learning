package com.chandan;

import java.util.Scanner;

/**
 * Created by chandan on 26/10/18.
 */
public class OddCount {
   public int countSubarrays(int a[],
                             int n, int m) {
      int count = 0;
      int prefix[] = new int[n];
      int odd = 0;

      // traverse in the array
      for (int i = 0; i < n; i++) {
         prefix[odd]++;

         // if array element is odd
         if ((a[i] & 1) == 1) {
            odd++;
         }

         // when number of odd
         // elements >= M
         if (odd >= m) {
            count += prefix[odd - m];
         }
      }

      return count;
   }

   public int countSubarraysWithAtmostOddNumber(int a[], int n, int m) {
      int count = 0;
      for (int i = 0; i <= m; i++) {
         count += countSubarrays(a, n, i);
      }

      return count;
   }

   public static void main(String[] args) {
      OddCount obj = new OddCount();
/*int[] arr = { 2, 2, 5, 6, 9, 2, 11 };*/

      int[] arr;

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();

      int res = obj.countSubarraysWithAtmostOddNumber(arr, arr.length, k);
      System.out.println(res);

   }
}