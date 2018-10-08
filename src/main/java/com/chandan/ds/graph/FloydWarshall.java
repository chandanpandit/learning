package com.chandan.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Calculates All pair shortest path.
 * Is a classical example of Dynamic Programming
 * Time Complexity = O(|V|^3)
 */
public class FloydWarshall {
   private static final int INF = Integer.MAX_VALUE; // infinity

   public static void main(String[] args) {

      /*int v = 4;
      Graph g = new Graph(v);
      g.addEdge(0, 2, -2);
      g.addEdge(1, 0, 4);
      g.addEdge(1, 2, 3);
      g.addEdge(2, 3, 2);
      g.addEdge(3, 1, -1);
      // Input will be the
      int[][] next = new int[v][v];
      int[][] d = floydWarshall(g,next);
      printPaths(d,next);*/
   }

   private static void printPaths(int[][] d,int[][] next) {
      int v = d.length;
      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            String distance = d[i][j] == INF ? "INF" : String.valueOf(d[i][j]);
            System.out.println(i+" -> "+j+" : "+distance+ " | "+getPath(i,j,next));
         }
         System.out.println();
      }
   }

   private static String getPath(int s,int d,int[][] next){
      if(next[s][d] == -1)
         return "";
      StringBuilder sb = new StringBuilder();
      sb.append(s);
      while (s != d){
         sb.append("->"+next[s][d]);
         s = next[s][d];
      }

      return sb.toString();
   }

   private static int[][] floydWarshall(Graph g, int[][] next) {
      int v = g.V;
      int[][] d = new int[v][v];

      // initialize
      for (int i = 0; i < v; i++) {
         Arrays.fill(d[i],INF); // fill everything as infinity
         Arrays.fill(next[i],-1);
      }
      for (int i = 0; i < v; i++) {
         d[i][i] = 0;
         // for each edge set distance to be length of edge
         for (Graph.Node node : g.adj[i]){
            d[i][node.dest] = node.weight;
            next[i][node.dest] = node.dest;
         }
      }

      for (int k = 0; k < v; k++) {
         for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
               if (d[i][j] > add(d[i][k], d[k][j])) {
                  d[i][j] = add(d[i][k], d[k][j]);
                  next[i][j] = next[i][k];
               }
            }
         }
      }

      return d;
   }

   private static int add(int i, int j) {
      if (i == INF || j == INF) {
         return INF;
      }
      return i + j;
   }

   static class Graph {
      int V;
      LinkedList<Node>[] adj;

      public Graph(int v) {
         V = v;
         adj = new LinkedList[v];
         for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
         }
      }

      public void addEdge(int s, int d, int w) {
         adj[s].add(new Node(d, w));
      }

      static class Node {
         int dest;
         int weight;

         public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
         }
      }
   }
}