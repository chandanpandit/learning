package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by chandan on 6/11/17.
 */
public class MotherVertex {
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
      void addEdge(int s,int d){
         adj[s].add(d);
      }

      void DFSUtil(int v,boolean[] visited){
         visited[v] = true;
         Iterator<Integer> it = adj[v].listIterator();
         while (it.hasNext()){
            int n = it.next();
            if(!visited[n]){
               DFSUtil(n,visited);
            }
         }
      }

      public int findMother(){
         // find the last finished vertex v in DFS
         int v = -1;
         boolean[] visited = new boolean[V];
         for (int i = 0; i < V; i++) {
            if(!visited[i]) {
               DFSUtil(i, visited);
               v = i;
            }
         }
         // check if all vertices are reachable from v
         for (int i = 0; i < V; i++) {
            visited[i] = false;
         }

         DFSUtil(v,visited);

         for (int i = 0; i < V; i++) {
            if(!visited[i]){
               return -1;
            }
         }

         return v;
      }

   }

   public static void main(String[] args) {
      Graph g = new Graph(7);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 3);
      g.addEdge(4, 1);
      g.addEdge(6, 4);
      g.addEdge(5, 6);
      g.addEdge(5, 2);
      g.addEdge(6, 0);

      System.out.println("A mother vertex is " + g.findMother());
   }
}
