package com.chandan.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroSumMatix {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt(); // rows
      int m = s.nextInt(); // col
      int a[][] = new int[n][m];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            a[i][j] = s.nextInt();
         }
      }
      sumZeroMatrix(a, n, m);
   }

   static void sumZeroMatrix(int a[][], int row, int col) {
      int ftop = 0;
      int fbottom = 0;
      int fleft = 0;
      int fright = 0;
      int maxl = Integer.MIN_VALUE;

      for (int left = 0; left < col; left++) {
         int temp[] = new int[col];
         for (int right = left; right < col; right++) {
            for (int i = 0; i < row; i++) {
               temp[i] += a[i][right];
            }

            int[] sumZero = sumZero(temp);

            int ele = (sumZero[2] - sumZero[1] + 1) * (right - left + 1);

            if(sumZero[0] == 0 && ele > maxl) {
               ftop = sumZero[1];
               fbottom = sumZero[2];
               fleft = left;
               fright = right;
               maxl = ele;
            }
         }
      }
      if (ftop == 0 && fbottom == 0 && fleft == 0 &&
          fright == 0 && a[0][0] != 0)
         return;

      System.out.println((fbottom-ftop+1) * (fright-fleft+1));
   }

   static int[] sumZero(int[] temp) {
      int tmp[] = { Integer.MAX_VALUE, 0, -1 };
      int sum = 0, MAX_LENGTH =0;
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < temp.length; i++) {
         sum += temp[i];
         if (temp[i] == 0) {
            tmp[0] = 0;
            tmp[1] = i;
            tmp[2] = i;
            MAX_LENGTH = 1;
         }
         if (sum == 0) {
            if(MAX_LENGTH < i+1) {
               tmp[0] = 0;
               tmp[1] = 0;
               tmp[2] = i;
            }
            MAX_LENGTH = i + 1;
         }

         if(map.get(sum) != null){
            int old = MAX_LENGTH;
            MAX_LENGTH = Math.max(old, i - map.get(sum));
            if(MAX_LENGTH > old){
               tmp[0] = 0;
               tmp[1] = map.get(sum) + 1;
               tmp[2] = i;
            }
         } else {
            map.put(sum, i);
         }
      }
      return tmp;
   }
}