package com.chandan.ds.array;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix {
   public static void main(String[] args) {
      int[][] a = {
         {0, 0, 1, 1},
         {0, 1, 0, 0},
         {1, 0, 1, 0},
         {1, 0, 1, 1}
      };
      List<Pair> results = solve(a);

      for (Pair pair : results) {
         System.out.println("(" + pair.i + "," + pair.j + ")");
      }

   }

   static List<Pair> solve(int[][] a) {
      List<Pair> results = new ArrayList<>();
      int rows = a.length;
      int cols = a[0].length;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            if (!containsOther1InRow(i, j, a) && !containsOther1InColumn(i, j, a)) {
               results.add(new Pair(i, j));
            }
         }
      }

      return results;
   }

   private static boolean containsOther1InColumn(int i, int j, int[][] a) {
      for (int k = 0; k < a.length; k++) {
         if (k != i && a[k][i] == 1) {
            return true;
         }
      }
      return false;
   }

   private static boolean containsOther1InRow(int i, int j, int[][] a) {
      for (int k = 0; k < a.length; k++) {
         if (k != j && a[i][k] == 1) {
            return true;
         }
      }
      return false;
   }
}

class Pair {
   int i, j;

   public Pair(int i, int j) {
      this.i = i;
      this.j = j;
   }
}