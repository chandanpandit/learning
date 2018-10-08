package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class KCores {
   static class Graph {
      int V;
      LinkedList<Integer> adj[];

      public Graph(int v) {
         V = v;
         adj = new LinkedList[V];
         for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
         }
      }

      void addEdge(int s, int d) {
         adj[s].add(d);
         adj[d].add(s);
      }

      void printKCores(int k) {
         // first write the degrees in an array
         // traverse in DFS and keep decreasing the degree of adjacent nodes if degree of current node is less than k.
         // also decrease degree of current node if it is less than k.finally return the node  if degree is less than k.
         int[] degree = new int[V];
         int start = -1;
         int minDeg = Integer.MAX_VALUE;
         boolean[] visited = new boolean[V];
         for (int i = 0; i < V; i++) {
            degree[i] = adj[i].size();
            if(degree[i] < minDeg){
               minDeg = degree[i];
               start = i;
            }
         }

         DFSUtil(start,visited,degree,k);

         //set degree for all vertices
         for (int i = 0; i < V; i++) {
            if(!visited[i]){
               DFSUtil(i,visited,degree,k);
            }
         }

         System.out.println("K-Cores : \n");
         // print now vertices which have degree greater than equal to k
         for (int i = 0; i < V; i++) {
            if(degree[i] >= k){
               System.out.print("["+i+"] -> ");
               Iterator<Integer> it = adj[i].listIterator();
               while (it.hasNext()){
                  int n = it.next();
                  if(degree[n] >= k){
                     System.out.print(" -> [" + n + "]");
                  }
               }
               System.out.println();
            }
         }
      }

      boolean DFSUtil(int s,boolean[] visited,int[] degree,int k){
         visited[s] = true;
         Iterator<Integer> it = adj[s].listIterator();
         while (it.hasNext()){
            int n = it.next();
            if(degree[s] < k){
               degree[n]--;
            }
            if(!visited[n]){
               if(DFSUtil(n,visited,degree,k)){
                  degree[s]--;
               }
            }
         }

         return degree[s] < k;
      }
   }

   public static void main(String[] args) {
      int k = 3;
      Graph g1 = new Graph(9);
      g1.addEdge(0, 1);
      g1.addEdge(0, 2);
      g1.addEdge(1, 2);
      g1.addEdge(1, 5);
      g1.addEdge(2, 3);
      g1.addEdge(2, 4);
      g1.addEdge(2, 5);
      g1.addEdge(2, 6);
      g1.addEdge(3, 4);
      g1.addEdge(3, 6);
      g1.addEdge(3, 7);
      g1.addEdge(4, 6);
      g1.addEdge(4, 7);
      g1.addEdge(5, 6);
      g1.addEdge(5, 8);
      g1.addEdge(6, 7);
      g1.addEdge(6, 8);
      g1.printKCores(k);

      System.out.println();

      Graph g2 = new Graph(13);
      g2.addEdge(0, 1);
      g2.addEdge(0, 2);
      g2.addEdge(0, 3);
      g2.addEdge(1, 4);
      g2.addEdge(1, 5);
      g2.addEdge(1, 6);
      g2.addEdge(2, 7);
      g2.addEdge(2, 8);
      g2.addEdge(2, 9);
      g2.addEdge(3, 10);
      g2.addEdge(3, 11);
      g2.addEdge(3, 12);
      g2.printKCores(k);

   }
}
