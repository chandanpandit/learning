package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class BFSGraph {
   private int v;// number of vertices
   private LinkedList<Integer>[] adj;
   private int[] levels;
   private int[] parent;

   public BFSGraph(int v) {
      this.v = v;
      this.adj = new LinkedList[v];
      for (int i = 0; i < v; i++) {
         adj[i] = new LinkedList<>();
      }
      this.levels = new int[v];
      this.parent = new int[v];
   }

   public void addEdge(int s, int d) {
      adj[s].add(d);
      adj[d].add(s);
   }

   public void bfs(int s) { // s -> start vertex
      boolean[] visited = new boolean[v];
      int level = 0;
      parent[s] = 0;
      levels[s] = level;
      Queue<Integer> queue = new LinkedList<>();
      queue.add(s);
      visited[s] = true;
      while (!queue.isEmpty()){
         Integer next = queue.poll();
         System.out.print(next+", ");
         Iterator<Integer> it = adj[next].listIterator();

         while (it.hasNext()){
            Integer i = it.next();
            if(!visited[i]){
               visited[i] = true;
               levels[i] = level;
               parent[i] = next;
               queue.add(i);
            }
         }

         level++;
      }
   }

   public void printShortestPath(){
      for (int i = 0; i < v; i++) {
         printShortestPath(i,parent);
         System.out.println();
      }
   }

   private void printShortestPath(int i, int[] parent) {
      if (parent[i] != 0)
         printShortestPath(parent[i],parent);
      System.out.print(i+"->");
   }

   private void printArray(int[] a){
      System.out.print("Array : ");
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i]+", ");
      }
      System.out.println();
   }
}

public class BFSGraphTestDrive {
   public static void main(String[] args) {
      BFSGraph graph = new BFSGraph(8);
      graph.addEdge(0,1);
      graph.addEdge(0,2);
      graph.addEdge(1,2);
      graph.addEdge(1,3);
      graph.addEdge(2,5);
      graph.addEdge(3,5);
      graph.addEdge(4,5);
      graph.addEdge(4,6);
      graph.addEdge(4,7);
      graph.addEdge(5,7);
      System.out.print("BFS : ");
      graph.bfs(2);
      System.out.println("\nPaths : ");
      graph.printShortestPath();
   }
}