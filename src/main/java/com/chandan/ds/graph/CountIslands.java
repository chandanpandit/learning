package com.chandan.ds.graph;

public class CountIslands {
   public static void main(String[] args) {
      int[][] g = {{1, 1, 0},
                   {0, 0, 1},
                   {1, 0, 1},
                  };
      int count =  countIsland(g);
      System.out.println("Count = "+count);
   }

   private static int countIsland(int[][] g) {
      int n = g.length;
      int m = g[0].length;
      int count = 0;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if(g[i][j] != 0){
               count++;
               destroyIsland(g,i,j,n,m);
            }
         }
      }

      return count;
   }

   private static void destroyIsland(int[][] g, int i, int j,int n,int m) {
      g[i][j] = 0;
      // call destroy island for all the adjacent nodes
      if(i > 0 && g[i-1][j] != 0)
         destroyIsland(g,i-1,j,n,m);
      if(i < n-1 && g[i+1][j] != 0)
         destroyIsland(g,i+1,j,n,m);

      if(j > 0 && g[i][j-1] != 0)
         destroyIsland(g,i,j-1,n,m);
      if(j < m-1 && g[i][j+1] != 0)
         destroyIsland(g,i,j+1,n,m);

      if(i > 0 && j > 0 && g[i-1][j-1] != 0)
         destroyIsland(g,i-1,j-1,n,m);
      if(i < n-1 && j < m-1 && g[i+1][j+1] != 0)
         destroyIsland(g,i+1,j+1,n,m);

      if(j > 0 && i < n-1 && g[i+1][j-1] != 0)
         destroyIsland(g,i+1,j-1,n,m);
      if(j < m-1 && i > 0  && g[i-1][j+1] != 0)
         destroyIsland(g,i-1,j+1,n,m);

   }
}