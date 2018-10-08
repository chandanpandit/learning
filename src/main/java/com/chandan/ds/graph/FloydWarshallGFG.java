package com.chandan.ds.graph;

import java.util.Scanner;

public class FloydWarshallGFG {

   private static final int INF = Integer.MAX_VALUE;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t > 0){
         int v = sc.nextInt();
         int[][] g = new int[v][v];
         for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
               g[i][j] = sc.nextInt();
            }
         }

         int[][] d = floydWarshall(g);

         for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
               System.out.print(d[i][j]+ " ");
            }
         }
         System.out.println();
         t--;
      }
   }

   private static int[][] floydWarshall(int[][] g) {
      int v = g.length;
      int[][] d = new int[v][v];

      // set distance between edge vertices as edge weight
      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
               d[i][j] = g[i][j];
         }
      }

      // now for each k, optimize distances
      for (int k = 0; k < v; k++) {
         for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
               if(d[i][j] > add(d[i][k] , d[k][j])){
                  d[i][j] = add(d[i][k] , d[k][j]);
               }
            }
         }
      }

      return d;
   }

   private static int add(int i,int j) {
      if(i == INF || j == INF)
         return INF;
      return i+j;
   }

   private static void print2DArray(int[][] a){
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++) {
            System.out.print(a[i][j]+" ");
         }
         System.out.println();
      }
   }

}