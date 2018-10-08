package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Cycle {
   static class Graph {
      int v;
      LinkedList<Integer> adj[];

      public Graph(int v) {
         this.v = v;
         adj = new LinkedList[v];
         for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
         }
      }

      void addEdge(int s, int d) {
         adj[s].add(d);
      }

      private boolean hasCycleUtil(int s,boolean[] visited,boolean[] recStack) {
         visited[s] = true;
         recStack[s] = true;
         Iterator<Integer> it = adj[s].listIterator();
         while (it.hasNext()){
            int n = it.next();
            if(recStack[n])
               return true;
            if(!visited[n] && hasCycleUtil(n,visited,recStack))
               return true;
         }
         recStack[s] = false;

         return false;
      }

      public boolean isCyclic() {
         boolean[] visited = new boolean[v];
         boolean[] recStack = new boolean[v];
         for (int i = 0; i < v; i++) {
            if(!visited[i] && hasCycleUtil(i,visited,recStack))
               return true;
         }
         return false;
      }
   }

   public static void main(String[] args) {
      Graph g = new Graph(4);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      //g.addEdge(2, 0);
      g.addEdge(2, 3);
      //g.addEdge(3, 3);

      if (g.isCyclic()) {
         System.out.println("Graph contains cycle");
      } else {
         System.out.println("Graph doesn't contain cycle");
      }
   }
}
