package com.chandan.ds.trees;

public interface BTree<E extends Comparable<E>> {
   void insertNode(E data);
   void printPreOrder();
   void printInOrder();
   void printPostOrder();
   void printLevelOrder();
   boolean findNode(E data);
}

