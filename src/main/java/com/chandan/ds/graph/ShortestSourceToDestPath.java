package com.chandan.ds.graph;

import java.util.*;

public class ShortestSourceToDestPath {
   public static void main(String[] args) {
      /*int[][] graph = {
         {1,0,0,0},
         {1,1,0,1},
         {0,1,1,1}
      };
      Point source = new Point(0,0);
      Point dest = new Point(2,3);*/
      /*int[][] graph = {
         {1,1,1,1},
         {0,0,0,1},
         {0,0,0,1}
      };
      Point source = new Point(0,0);
      Point dest = new Point(0,3);*/
      /*Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0) {
         int n, m;
         n = sc.nextInt();
         m = sc.nextInt();
         int[][] graph = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               graph[i][j] = sc.nextInt();
            }
         }

         Point source = new Point(0, 0);
         int x = sc.nextInt();
         int y = sc.nextInt();
         Point dest = new Point(x, y);

         int len = bfsShortestPath(graph, source, dest);
         System.out.println(len);
         t--;
      }*/
      /*int[][] g =
      {
         { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
         { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
         { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
         { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
         { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
         { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
         { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
         { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
         { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
      };

      Point source =  new Point(0, 0);
      Point dest = new Point(3, 4);
      System.out.println(bfsShortestPath(g,source,dest));*/
   }

   private static int bfsShortestPath(int[][] graph, Point source, Point dest) {
      Set<Point> visited = new HashSet<>();
      Map<Point,Integer> distance = new HashMap<>();
      Queue<Point> queue = new LinkedList<>();
      queue.add(source);
      distance.put(source,0);
      visited.add(source);
      int d = 1;

      while (!queue.isEmpty()) {
         Queue<Point> next = new LinkedList<>();
         while (!queue.isEmpty()) {
            Point u = queue.poll();
            for (Point v : getAdjPoints(graph,u)) { // iterate for all adj nodes
               if (!visited.contains(v)) {
                  distance.put(v, d);
                  next.add(v);
                  visited.add(v);
               }
            }
         }

         d++;
         queue = next;
      }

      return distance.get(dest) == null ? -1 : distance.get(dest);
   }

   private static boolean isValidPoint(int[][] graph,Point v) {
      return v.x >= 0 && v.x < graph.length && v.y >= 0 && v.y < graph[0].length && graph[v.x][v.y] == 1;
   }

   private static List<Point> getAdjPoints(int[][] g,Point u) {
      /*int[] x = {-1, -1, -1,  0, 0,  1, 1, 1};
      int[] y = {-1,  0,  1, -1, 1, -1, 0, 1};*/
      int[] x = {-1,  0, 0, 1 };
      int[] y = { 0, -1, 1, 0 };
      List<Point> adj = new ArrayList<>();
      for (int i = 0; i < x.length; i++) {
         Point v = new Point(u.x + x[i], u.y + y[i]); // next point
         if(isValidPoint(g,v)){
            adj.add(v);
         }
      }

      return adj;
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