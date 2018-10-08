package com.chandan.ds.dp;

import java.util.Scanner;

/**
 * Created by chandan on 6/10/18.
 * Ref : https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix/0
 */
public class MaximumSizeSquareSubMatrix {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int m = sc.nextInt();
         int[][] matrix = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               matrix[i][j] = sc.nextInt();
            }
         }
         int maxSize = maxSizeSquare(matrix, n, m);
         System.out.println(maxSize);
      }
   }

   private static int maxSizeSquare(int[][] matrix, int n, int m) {
      int[][] S = new int[n][m];
      // S[i][j] -> means the maximum size square with 1 which can be formed
      // with M[i][j] being the rightmost & bottom-most element

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if (i == 0 || j == 0) {
               S[i][j] = matrix[i][j];
            } else {
               if (matrix[i][j] == 0) {
                  // if current element is 0, which means rightmost
                  // & bottom most element is 0. So square size =0
                  S[i][j] = 0;
               } else {
                  // else minimum of 3 + 1
                  S[i][j] = Math.min(S[i - 1][j - 1], Math.min(S[i - 1][j], S[i][j - 1])) + 1;
               }
            }
         }
      }

      int max = S[0][0];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            max = Math.max(max, S[i][j]);
         }
      }

      return max;
   }
}