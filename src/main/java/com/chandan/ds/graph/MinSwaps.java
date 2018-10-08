package com.chandan.ds.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwaps {
   public static void main(String[] args) {
      int[] a = {1, 5, 4, 3, 2};
      int count = countSwaps(a,a.length);
      System.out.println(count);
   }

   private static int countSwaps(int[] A,int N) {
      Map<Integer,Integer> map = new HashMap<>();
      for (int i = 0; i < N; i++) {
         map.put(A[i],i);
      }
      Arrays.sort(A);
      for (int i = 0; i < N; i++) {
         A[i] = map.get(A[i]); // index in original array
      }
      // now we have to count swaps needed to move the element at A[i] (original index) to i(sorted index)
      int swaps = 0;
      for (int i = 0; i < N; i++) {
         int val = A[i];
         if(val < 0)
            continue;
         while (val != i){
            int newVal = A[val];
            A[val] = -1; // marked visited
            val = newVal;
            swaps++;
         }
         A[i] = -1; // marked visited
      }

      return swaps;
   }
}