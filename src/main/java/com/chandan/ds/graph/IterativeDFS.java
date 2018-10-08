package com.chandan.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chandan on 7/11/17.
 */
public class IterativeDFS {
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

      void DFSUtil(int s,boolean[] visited,Stack<Integer> output){
         Stack<Integer> stack  = new Stack<Integer>();
         visited[s] = true;
         stack.push(s);

         while (!stack.isEmpty()){
            int u = stack.pop();
            output.push(u);
            Iterator<Integer> it  = adj[u].listIterator();
            while (it.hasNext()){
               int n = it.next();
               if(!visited[n]){
                  visited[n] = true;
                  stack.push(n);
               }
            }
         }

         while (!output.isEmpty()) {
            System.out.print(output.pop() + " ");
         }
      }

      void DFS(){
         Stack<Integer> output = new Stack<Integer>();
         boolean[] visited = new boolean[V];
         for (int i = 0; i < V; i++) {
            if(!visited[i]){
               DFSUtil(i,visited,output);
            }
         }
      }
   }

   public static void main(String[] args) {
      Graph g = new Graph(5);
      g.addEdge(1, 0);
      g.addEdge(2, 1);
      g.addEdge(3, 4);
      g.addEdge(4, 0);
      System.out.println("Following is Depth First Traversal\n");
      g.DFS();
   }
}
