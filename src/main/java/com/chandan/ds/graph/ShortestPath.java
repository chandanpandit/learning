package com.chandan.ds.graph;

import java.util.*;

public class ShortestPath {

   public static void main(String[] args) {
      /*Graph g = new Graph(7);
      g.addEdge(0, 1, 2);
      g.addEdge(1, 2, 7);
      g.addEdge(1, 4, 2);
      g.addEdge(1, 3, 15);
      g.addEdge(2, 6, 4);
      g.addEdge(3, 2, 3);
      g.addEdge(3, 5, 1);
      g.addEdge(3, 1, 2);
      g.addEdge(4, 5, 11);
      g.addEdge(5, 3, 1);
      g.addEdge(6, 4, 2);
      int s = 0;*/


      Graph g = new Graph(6);
      g.addEdge(0, 1, 5);
      g.addEdge(0, 2, 3);
      g.addEdge(1, 3, 6);
      g.addEdge(1, 2, 2);
      g.addEdge(2, 4, 4);
      g.addEdge(2, 5, 2);
      g.addEdge(2, 3, 7);
      g.addEdge(3, 4, -1);
      g.addEdge(4, 5, -2);
      int s = 1;

      printShortestPaths(g, s);
   }

   public static void printShortestPaths(Graph g, int s) {
      // will compute shortest path and then print paths
      // d[u] -> denotes distance of vertex u from source s
      int V = g.V;
      int[] d = new int[V];
      int[] parent = new int[V];

      Arrays.fill(d, Integer.MAX_VALUE);
      Arrays.fill(parent, -1);
      d[s] = 0;
      parent[s] = -1;

      List<Integer> topologicalOrder = topologicalSort(g);
      for (int u : topologicalOrder) {
         Iterator<Integer> it = g.adj[u].listIterator(); //
         while (it.hasNext()) {
            int v = it.next();
            relax(u, v, d, parent, g);
         }
      }

      // now paths have been calculated
      for (int i = 0; i < V; i++) {
         System.out.print("Path from " + s + " -> " + i + " length : " + d[i] + " : ");
         int temp = i;
         while (parent[temp] != -1) {
            System.out.print(temp + " <- ");
            temp = parent[temp];
         }
         System.out.println(s);
      }
   }

   private static void relax(int u, int v, int[] d, int[] parent, Graph g) {
      if (!isInfinity(d[u]) && d[v] > d[u] + g.weight(new Edge(u, v))) {
         //System.out.println(d[v]+"|"+(d[u] + g.weight(new Edge(u, v))));
         d[v] = d[u] + g.weight(new Edge(u, v));
         parent[v] = u;
      }
   }

   private static boolean isInfinity(int i) {
      return i == Integer.MAX_VALUE;
   }

   private static List<Integer> topologicalSort(Graph g) {
      // same as DFS but node is visited only after all its children have been visited
      boolean[] visited = new boolean[g.V];
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < g.V; i++) {
         if (!visited[i]) {
            topologicalSortUtil(g, i, visited, stack);
         }
      }
      List<Integer> topologicalOrder = new ArrayList<>();
      while (!stack.isEmpty()) {
         topologicalOrder.add(stack.pop());
      }

      return topologicalOrder;
   }

   private static void topologicalSortUtil(Graph g, int s, boolean[] visited, Stack<Integer> stack) {
      visited[s] = true;
      Iterator<Integer> it = g.adj[s].listIterator();
      while (it.hasNext()) {
         int v = it.next();
         if (!visited[v]) {
            topologicalSortUtil(g, v, visited, stack);
         }
      }

      // all children visited, so add this to visited list
      stack.push(s);
   }

   static class Edge {
      int src;// source
      int dest; // dest

      public Edge(int src, int dest) {
         this.src = src;
         this.dest = dest;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (!(o instanceof Edge)) {
            return false;
         }

         Edge edge = (Edge) o;

         if (src != edge.src) {
            return false;
         }
         return dest == edge.dest;

      }

      @Override
      public int hashCode() {
         int result = src;
         result = 31 * result + dest;
         return result;
      }
   }

   static class Graph {
      int V;
      LinkedList<Integer>[] adj;
      Map<Edge, Integer> weights;


      public Graph(int v) {
         V = v;
         weights = new HashMap<>();
         adj = new LinkedList[v];
         for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
         }
      }

      public void addEdge(int s, int d, int w) {
         adj[s].add(d);
         weights.put(new Edge(s, d), w);
      }

      public int weight(Edge edge) {
         return weights.get(edge);
      }
   }
}
