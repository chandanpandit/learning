package com.chandan.ds.graph;

import java.util.Arrays;
import java.util.Stack;

public class KhosarajuSCC {
   public static void main(String[] args) {
      /*Graph g = new Graph(5);
      g.addEdge(1,0);
      g.addEdge(0,2);
      g.addEdge(2,1);
      g.addEdge(0,3);
      g.addEdge(3,4);*/

      /*Graph g = new Graph(3);
      g.addEdge(0,1);
      g.addEdge(1,2);
      g.addEdge(2,0);*/

      //1 2 0 1 2 3 3 1
      Graph g = new Graph(4);
      g.addEdge(1,2);
      g.addEdge(0,1);
      g.addEdge(2,3);
      g.addEdge(3,1);

      int sccCount = khosaraju(g);
      System.out.println(sccCount);
   }

   static int khosaraju(Graph g) {
      Stack<Integer> stack = new Stack<>();
      boolean[] visited = new boolean[g.V];
      for (int i = 0; i < g.V; i++) {
         if(!visited[i])
            dfsUtil(g, i, stack, visited);
      }
      // now Stack contains the elements visited according to time
      // create transpose graph
      Graph transpose = transpose(g);
      Arrays.fill(visited, false); // re-initialize visited array
      int count = 0;
      Stack<Integer> localStack = new Stack<>();
      while (!stack.isEmpty()) {
         int u = stack.pop();
         if (!visited[u]) {
            count++;
            dfsUtil(transpose, u, localStack, visited);
            printSCC(localStack);
         }
      }

      return count;
   }

   private static void printSCC(Stack<Integer> stack) {
      System.out.print("SCC = ");
      while (!stack.isEmpty()) {
         System.out.print(stack.pop() + ",");
      }
      System.out.println();
   }

   private static Graph transpose(Graph g) {
      Graph transpose = new Graph(g.V);
      for (int u = 0; u < g.V; u++) {
         for (Integer v : g.adj[u]) {
            transpose.addEdge(v, u);
         }
      }

      return transpose;
   }

   private static void dfsUtil(Graph g, int u, Stack<Integer> stack, boolean[] visited) {
      visited[u] = true;
      for (Integer v : g.adj[u]) {
         if (!visited[v]) {
            dfsUtil(g, v, stack, visited);
         }
      }
      stack.push(u);
   }
}