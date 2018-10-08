package com.chandan.ds.graph;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5,0);
        //g.printAllEdges();
        //g.printBFS(4);
        //g.printDFS();
    }
}
