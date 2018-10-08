package com.chandan.ds.graph;

import java.util.*;

public class PathExists {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int t = scanner.nextInt();
      for (int i = 0; i < t; i++) {
         int n = scanner.nextInt();
         int[][] g = new int[n][n];
         Point source = null,dest = null;
         for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
               g[j][k] = scanner.nextInt();
               if(g[j][k] == 1)
                  source = new Point(j,k);
               if(g[j][k] == 2)
                  dest = new Point(j,k);
            }
         }
         boolean hasPath = false;
         if(source != null && dest != null){
            if(source.equals(dest)){
               hasPath = true;
            }else {
               Set<Point> visited = new HashSet<>();
               hasPath = hasPath(g, source, dest, visited);
            }
         }
         System.out.println(hasPath ? "1" : "0");
      }
   }

   private static boolean hasPath(int[][] g, Point source, Point dest, Set<Point> visited) {
      // do DFS
      visited.add(source);
      for (Point v : getAdjacent(g,source)){
         if(v.equals(dest))
            return true;
         if(!visited.contains(v) && hasPath(g, v, dest, visited)) {
            return true;
         }
      }
      return false;
   }

   private static List<Point> getAdjacent(int[][] g,Point s) {
      List<Point> adj = new ArrayList<>();
      int[] r = {-1,  0, 0, 1 };
      int[] c = { 0, -1, 1, 0 };
      for (int i = 0; i < r.length; i++) {
         Point p = new Point(s.x + r[i], s.y + c[i]);
         if(isValid(g,p)){
            adj.add(p);
         }
      }

      return adj;
   }

   private static boolean isValid(int[][] g, Point p) {
      int n = g.length;
      return p.x >= 0 && p.x < n && p.y >= 0 && p.y < n &&  (g[p.x][p.y] == 3 || g[p.x][p.y] == 2);
   }

   static class Point{
      int x,y;

      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public boolean equals(Object o) {

         if (this == o) {
            return true;
         }
         if (!(o instanceof Point)) {
            return false;
         }

         Point point = (Point) o;

         if (x != point.x) {
            return false;
         }
         return y == point.y;

      }

      @Override
      public int hashCode() {
         int result = x;
         result = 31 * result + y;
         return result;
      }
   }
}