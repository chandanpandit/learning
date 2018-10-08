package com.chandan.ds.graph;

import java.util.*;

public class ShortestPathDijkastra {

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

      // create priority queue of the d values
      PriorityQueue<QueueElm> queue = new PriorityQueue<>(new QueueElmComparator());
      for (int i = 0; i < V; i++) {
         queue.add(new QueueElm(i,d[i]));
      }

      while (!queue.isEmpty()){
         int u = queue.remove().i;
         Iterator<Integer> it = g.adj[u].listIterator();
         while (it.hasNext()){
            int v = it.next();
            relax(u,v,d,parent,g,queue);
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

   private static void decreaseKey(int i, int[] d,int newVal, PriorityQueue<QueueElm> queue ){
      QueueElm queueElm = new QueueElm(i,d[i]);
      queue.remove(queueElm);
      // decrease and insert again
      d[i] = newVal;
      queueElm.value = newVal;
      queue.add(queueElm);
   }

   private static void relax(int u, int v, int[] d, int[] parent, Graph g,PriorityQueue<QueueElm> queue) {
      if (!isInfinity(d[u]) && d[v] > d[u] + g.weight(new Edge(u, v))) {
         //System.out.println(d[v]+"|"+(d[u] + g.weight(new Edge(u, v))));
         int newVal = d[u] + g.weight(new Edge(u, v));
         decreaseKey(v,d,newVal,queue);
         parent[v] = u;
      }
   }

   private static boolean isInfinity(int i) {
      return i == Integer.MAX_VALUE;
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

   static class QueueElm{
      int i;
      int value;

      public QueueElm(int i, int value) {
         this.i = i;
         this.value = value;
      }

      @Override
      public String toString() {
         return "QueueElm{" +
                "i=" + i +
                ", value=" + value +
                '}';
      }
   }

   static class QueueElmComparator implements Comparator<QueueElm>{

      @Override
      public int compare(QueueElm o1, QueueElm o2) {
         if(o1.value > o2.value)
            return 1;
         else if(o1.value < o2.value)
            return -1;
         return 0;
      }
   }
}
