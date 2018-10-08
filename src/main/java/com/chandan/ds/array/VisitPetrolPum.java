package com.chandan.ds.array;

public class VisitPetrolPum {
   public static void main(String[] args) {
      int[] d = {4, 6, 7, 4};
      int[] p = {6, 5, 3, 5};
      System.out.println(visit(p, d));

   }

   private static int visit(int[] p, int[] d) {
      int i = 0, j = i, s = 0, n = p.length;
      while (i < n) {
         while (s >= 0) { // enough petrol to visit
            s += (p[j] - d[j]);
            if (j == i) // we reached again to start
            {
               return i;
            }
            j = (j + 1) % n;
         }
         // not enough petrol to visit next node. start again from j
         i = j;
         if (i < n) {
            j = (i + 1) % n;
            s = p[i] - d[i];
         }
      }

      return -1;
   }
}