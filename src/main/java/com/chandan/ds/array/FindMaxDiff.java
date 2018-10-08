package com.chandan.ds.array;

import java.util.concurrent.*;

/**
 * find max(a[j] - a[i]) such that j >= i
 */

public class FindMaxDiff {
   public static void main(String[] args) {
      int[] a = {10, 1, 5, 7, 4, 14, 9, 1, 11, 13};
      System.out.println("Method 1 =" + findMaxDiff(a));
      System.out.println("Method 2 =" + findMaxDiff2(a));
      System.out.print("Method 3(Parallel ) =" + findDiffInParallel(a));
   }

   public static int findMaxDiff(int[] arr) {
      int min = arr[0];
      int maxDiff = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
         maxDiff = (maxDiff > (arr[i] - min)) ? maxDiff : (arr[i] - min);
         min = (arr[i] < min) ? arr[i] : min;
      }
      return maxDiff;
   }

   public static int findMaxDiff2(int[] a) {
      int n = a.length;
      int max = a[n - 1];
      int maxDiff = Integer.MIN_VALUE;
      for (int i = n - 1; i >= 0; i--) {
         max = Math.max(max, a[i]);
         maxDiff = Math.max(maxDiff, max - a[i]);
      }

      return maxDiff;
   }

   public static int findDiffInParallel(int[] a) {
      int maxDiff = Integer.MIN_VALUE;
      int n = a.length;
      ExecutorService service = Executors.newFixedThreadPool(2);
      int mid = n / 2;
      Future<Result> result1 = service.submit(new Task(a, 0, mid));
      Future<Result> result2 = service.submit(new Task(a, mid + 1, n - 1));
      try {
         Result r1 = result1.get();
         Result r2 = result2.get();
         maxDiff = Math.max(maxDiff, a[r1.j] - a[r1.i]); // individual result
         maxDiff = Math.max(maxDiff, a[r2.j] - Math.min(a[r1.i], a[r2.i]));
         maxDiff = Math.max(maxDiff, r2.max - r1.min);
      } catch (InterruptedException | ExecutionException e) {
         e.printStackTrace();
      } finally {
         service.shutdown();
      }

      return maxDiff;
   }

   static class Task implements Callable {
      private int[] a;
      private int start;
      private int end;

      public Task(int[] a, int start, int end) {
         this.a = a;
         this.start = start;
         this.end = end;
      }

      @Override
      public Result call() throws Exception {
         int min = a[end];
         int max = a[end];
         int i = end, j = end, maxIndex = end;
         int maxDiff = 0;
         for (int k = end; k >= start; k--) {
            min = Math.min(min, a[k]);
            if (a[k] > max) {
               max = a[k];
               maxIndex = k;
            }
            if ((max - a[k]) > maxDiff) {
               i = k;
               j = maxIndex;
               maxDiff = a[j] - a[i];
            }
         }

         return new Result(i, j, min, max);
      }
   }

   static class Result {
      int i, j, min, max;

      public Result(int i, int j, int min, int max) {
         this.i = i;
         this.j = j;
         this.min = min;
         this.max = max;
      }
   }
}