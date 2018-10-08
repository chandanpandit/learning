package com.chandan.ds.trees;

public class Node<E extends Comparable<E>> {
   E data;
   Node<E> left;
   Node<E> right;
   Node(E data){
      this.data = data;
   }
}
