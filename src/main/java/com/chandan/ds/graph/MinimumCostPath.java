package com.chandan.ds.graph;

import java.util.*;

public class MinimumCostPath {

   private final static int INF = Integer.MAX_VALUE;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0) {
         int n = sc.nextInt();
         int[][] g = new int[n][n];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               g[i][j] = sc.nextInt();
            }
         }
         // call shortest path algo using dijkastra
         int len = shortestPath(g);
         System.out.println(len);
         t--;
      }
   }

   private static int shortestPath(int[][] g) {
      // Initialize
      int n = g.length;
      int[][] d = new int[n][n];
      PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if(i == 0 && j == 0){
               d[0][0] = g[0][0];
            }else {
               d[i][j] = INF;
            }
            queue.add(new Node(i,j,d[i][j]));
         }
      }

      // fetch one by one from priority queue & relax edge u->v for all edge adjacent to u(fetched from queue)
      while (!queue.isEmpty()) {
         Node u = queue.remove();
         for (Node v : adjacent(u,g)) {
            relax(u, v, g, d, queue);
         }
      }

      return d[n - 1][n - 1];
   }

   private static void relax(Node u, Node v, int[][] g, int[][] d, PriorityQueue<Node> queue) {
      if(!isInfinity(d[u.i][u.j]) && ( d[v.i][v.j] > d[u.i][u.j] + g[v.i][v.j])){
         d[v.i][v.j] = d[u.i][u.j] + g[v.i][v.j];
         queue.remove(v);
         queue.add(new Node(v.i,v.j,d[v.i][v.j]));
      }
   }

   private static boolean isInfinity(int i) {
      return i == INF;
   }

   private static List<Node> adjacent(Node u,int[][] g) {
      int n = g.length;
      List<Node> adj = new ArrayList<>();
      int[] r = {-1, 0, 1, 0};
      int[] c = {0, -1, 0, 1};
      for (int i = 0; i < r.length; i++) {
         int x = u.i + r[i];
         int y = u.j + c[i];
         if( x >= 0 && x < n && y >= 0  && y < n ) {
            adj.add(new Node(x, y, 0));
         }
      }

      return adj;
   }

   private static class Node {
      int i, j, d;

      public Node(int i, int j, int d) {
         this.i = i;
         this.j = j;
         this.d = d;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (!(o instanceof Node)) {
            return false;
         }

         Node node = (Node) o;

         if (i != node.i) {
            return false;
         }
         return j == node.j;

      }

      @Override
      public int hashCode() {
         int result = i;
         result = 31 * result + j;
         return result;
      }
   }

   private static class NodeComparator implements Comparator<Node> {

      @Override
      public int compare(Node o1, Node o2) {
         return o1.d - o2.d;
      }
   }
}