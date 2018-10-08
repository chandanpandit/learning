package com.chandan.ds.dp.practice;

import java.util.Arrays;
import java.util.Scanner;

public class BoxStacking {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         Box[] boxes = new Box[n];
         for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int l = sc.nextInt();
            boxes[i] = new Box(h, w, l);
         }
         System.out.println(maxHeight(boxes));
      }
   }

   private static int maxHeight(Box[] boxes) {
      int maxHeight = 0;
      int maxD = 0;
      for (int i = 0; i < boxes.length; i++) {
         maxD = Math.max(maxD, Math.max(boxes[i].l, Math.max(boxes[i].w, boxes[i].h)));
      }
      // dp array to memoize
      int[][] dp = new int[maxD + 1][maxD + 1];
      for (int i = 0; i <= maxD; i++) {
         Arrays.fill(dp[i], -1);
      }
      // we don't know which box to place as base, so try them all
      for (int i = 0; i < boxes.length; i++) {
         int h = boxes[i].h;
         int w = boxes[i].w;
         int l = boxes[i].l;

         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, h, w) + l);
         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, w, h) + l);
         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, w, l) + h);
         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, l, w) + h);
         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, h, l) + w);
         maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, l, h) + w);
      }

      return maxHeight;
   }

   private static int maxHeight(int[][] dp, Box[] boxes, int x, int y) {
      // now iterate over boxes to check if we can place any of the 6 orientations.
      if (dp[x][y] >= 0) // if already solved for x,y, then return cached value
      {
         return dp[x][y];
      }
      int maxHeight = 0;
      for (int i = 0; i < boxes.length; i++) {
         int h = boxes[i].h;
         int w = boxes[i].w;
         int l = boxes[i].l;
         if (canBePlaced(x, y, h, w)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, h, w) + l);
         }
         if (canBePlaced(x, y, w, h)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, w, h) + l);
         }
         if (canBePlaced(x, y, w, l)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, w, l) + h);
         }
         if (canBePlaced(x, y, l, w)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, l, w) + h);
         }
         if (canBePlaced(x, y, h, l)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, h, l) + w);
         }
         if (canBePlaced(x, y, l, h)) {
            maxHeight = Math.max(maxHeight, maxHeight(dp, boxes, l, h) + w);
         }
      }
      dp[x][y] = maxHeight;

      return maxHeight;
   }

   // x,y -> base, a,b -> top
   private static boolean canBePlaced(int x, int y, int a, int b) {
      return a < x && b < y;
   }

   static class Box {
      int h, w, l;

      public Box(int h, int w, int l) {
         this.h = h;
         this.w = w;
         this.l = l;
      }
   }
}