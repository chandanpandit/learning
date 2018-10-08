package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by chandan on 6/11/17.
 */
public class TransitiveClosure {
   static class Graph{
      int V;
      LinkedList<Integer> adj[];

      public Graph(int v) {
         V = v;
         adj = new LinkedList[V];
         for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
         }
      }
      void addEdge(int src,int dest){
         adj[src].add(dest);
      }

      boolean[][] transitiveClosure(){
         boolean[][] tc = new boolean[V][V];
         for (int i = 0; i < V; i++) {
            DFSUtil(i,i,tc);
         }

         return tc;
      }
      void DFSUtil(int i,int v,boolean[][] tc){
         tc[i][v] = true;
         Iterator<Integer> it = adj[v].listIterator();
         while (it.hasNext()){
            int n = it.next();
            if(!tc[i][n])
               DFSUtil(i,n,tc);
         }
      }
   }

   public static void main(String[] args) {
      Graph g = new Graph(4);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(2, 3);
      g.addEdge(3, 3);

      System.out.println( "Transitive closure matrix is \n");
      boolean[][] tc = g.transitiveClosure();
      for (int i = 0; i < g.V; i++) {
         for (int j = 0; j < g.V; j++) {
            System.out.print(tc[i][j]== true ? "1 " : "0 ");
         }
         System.out.println();
      }
   }
}
