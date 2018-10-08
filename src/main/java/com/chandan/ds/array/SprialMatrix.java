package com.chandan.ds.array;

import java.util.Scanner;

public class SprialMatrix {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int m = sc.nextInt();
         int[][] a = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               a[i][j] = sc.nextInt();
            }
         }

         printSpiralReccursive(a, 0, 0, m - 1, n - 1);
         System.out.println();
         printSpiral(a, 0, 0, m - 1, n - 1);
         System.out.println();
      }
   }

   // x->m (m-x cols)
   // y->n (y-n rows)
   private static void printSpiralReccursive(int[][] a, int x, int y, int m, int n) {
      if (x > m || y > n) {
         return;
      }

      // print the outer rectangle
      for (int i = x; i <= m; i++) {
         System.out.print(a[y][i] + " ");
      }

      for (int i = y + 1; i <= n; i++) {
         System.out.print(a[i][m] + " ");
      }

      if (y < n) {
         for (int i = m - 1; i >= x; i--) {
            System.out.print(a[n][i] + " ");
         }
      }

      if (x < m) {
         for (int i = n - 1; i > y; i--) {
            System.out.print(a[i][x] + " ");
         }
      }

      printSpiralReccursive(a, x + 1, y + 1, m - 1, n - 1);
   }

   private static void printSpiral(int[][] a, int x, int y, int m, int n) {
      while (x <= m && y <= n) {
         // print the outer rectangle
         for (int i = x; i <= m; i++) {
            System.out.print(a[y][i] + " ");
         }

         for (int i = y + 1; i <= n; i++) {
            System.out.print(a[i][m] + " ");
         }

         if (y < n) {
            for (int i = m - 1; i >= x; i--) {
               System.out.print(a[n][i] + " ");
            }
         }

         if (x < m) {
            for (int i = n - 1; i > y; i--) {
               System.out.print(a[i][x] + " ");
            }
         }
         x++;
         y++;
         m--;
         n--;
      }
   }
}