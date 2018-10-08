package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
// Directed Graph Data structure
public class Graph {
   int V;
   LinkedList<Integer> adj[];
   public Graph(int V){
       this.V = V;
       adj = new LinkedList[V];
       for (int i = 0; i < V; i++) {
          adj[i] = new LinkedList<Integer>();
       }
    }

   public void addEdge(int src,int dest){
      // directed graph
      adj[src].add(dest);
      //adj[dest].add(src);
   }

   public void printAllEdges(){
      for (int i = 0; i < V; i++) {
         System.out.print("\n Vertices Connected From Vertex "+i+ " are :");
         Iterator<Integer> itr = adj[i].listIterator();
         while (itr.hasNext()){
            System.out.print(itr.next() + ",");
         }
      }
   }

   public void printDFS(){
      boolean[] visited= new boolean[V];
      for (int i = 0; i < V; i++) {
         if(!visited[i])
            DFSUtil(i,visited);
      }
   }

   private void DFSUtil(int i, boolean[] visited){
      visited[i] = true;
      Iterator<Integer> it = adj[i].listIterator();
      while (it.hasNext()){
         int n = it.next();
         if(!visited[n])
            DFSUtil(n,visited);
      }
      System.out.println(i+", ");
   }

   public void printBFS(int start){
      boolean[] visited = new boolean[V];
      Queue<Integer> queue = new LinkedList<Integer>();
      printBFS(start,visited,queue);
      for (int i = 0; i < V; i++) {
         if(!visited[i]){
            printBFS(i,visited,queue);
         }
      }
   }

   private void printBFS(int start, boolean[] visited, Queue<Integer> queue){
      queue.add(start);
      visited[start] = true;

      while (!queue.isEmpty()){
         int node = queue.poll();
         System.out.print(node + ", ");

         // add its adjacent nodes to queue if they are not visited
         Iterator<Integer> it = adj[node].listIterator();
         while (it.hasNext()){
            int v = it.next();
            if(!visited[v]) {
               visited[v] = true;
               queue.add(v);
            }
         }
      }
   }

}
