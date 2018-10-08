package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LongestDistanceInGraph {
   static class AdjacentNode{
      private int vertex,weight;

      public AdjacentNode(int vertex, int weight) {
         this.vertex = vertex;
         this.weight = weight;
      }
   }
   static class Graph{
      int V;
      LinkedList<AdjacentNode> adj[] ;

      public Graph(int v) {
         V = v;
         this.adj = new LinkedList[V];
         for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<AdjacentNode>();
         }
      }

      void addEdge(int src,int dest,int weight){
         adj[src].add(new AdjacentNode(dest,weight));
      }
      void longestPath(int s){
         Stack<Integer> stack = new Stack<Integer>();
         boolean[] visited = new boolean[V];
         for (int i = 0; i < V; i++) {
            if(!visited[i]){
               topologicalSortUtil(i,visited,stack);
            }
         }
         int[] dist = new int[V];
         for (int i = 0; i < V; i++) {
            dist[i] = Integer.MIN_VALUE;
         }
         dist[s] = 0;

         Iterator<AdjacentNode> it;
         while(!stack.isEmpty()){
            int u = stack.pop();
            it = adj[u].listIterator();
            while (it.hasNext()){
               AdjacentNode v = it.next();
               if(dist[v.vertex] < dist[u] + v.weight){
                  dist[v.vertex] = dist[u] + v.weight;
               }
            }
         }
         for (int i = 0; i < V; i++) {
            System.out.print(dist[i] == Integer.MIN_VALUE ? "INF, " : dist[i] + ", ");
         }
      }

      void topologicalSortUtil(int i,boolean[] visited,Stack<Integer> stack){
         visited[i] = true;
         Iterator<AdjacentNode> it = adj[i].listIterator();
         while (it.hasNext()){
            AdjacentNode n = it.next();
            if(!visited[n.vertex]){
               topologicalSortUtil(n.vertex,visited,stack);
            }
         }
         stack.push(i);
      }
   }

   public static void main(String[] args) {
      Graph g = new Graph(4);
      /*g.addEdge(0, 1, 5);
      g.addEdge(0, 2, 3);
      g.addEdge(1, 3, 6);
      g.addEdge(1, 2, 2);
      g.addEdge(2, 4, 4);
      g.addEdge(2, 5, 2);
      g.addEdge(2, 3, 12);
      g.addEdge(3, 5, 1);
      g.addEdge(3, 4, -1);
      g.addEdge(4, 5, -2);*/
      g.addEdge(0,3,3);
      g.addEdge(1,0,-1);
      g.addEdge(2,1,2);
      g.addEdge(2,3,7);
      int s = 1;
      System.out.println("Following are longest distances from source vertex "+s);
      g.longestPath(s);
   }
}
