package com.chandan.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> implements BTree<E> {
   private Node<E> root;

   @Override
   public void insertNode(E data) {
      root = insertNode(root,data);
   }

   private Node<E>  insertNode(Node<E> node,E data) {
      if(node == null)
         return new Node<>(data);
      else if(data.compareTo(node.data) < 0){
         node.left = insertNode(node.left,data);
      }else{
         node.right = insertNode(node.right,data);
      }

      return node;
   }

   @Override
   public void printPreOrder() {
      printPreOrder(root);
   }
   private void printPreOrder(Node<E> node) {
      if(node != null){
         System.out.print(node.data+",");
         printPreOrder(node.left);
         printPreOrder(node.right);
      }
   }

   @Override
   public void printInOrder() {
      printInOrder(root);
   }

   private void printInOrder(Node<E>  node){
      if(node != null){
         printInOrder(node.left);
         System.out.print(node.data+",");
         printInOrder(node.right);
      }
   }

   @Override
   public void printPostOrder() {
      printPostOrder(root);
   }
   private void printPostOrder(Node<E> node){
      if(node != null){
         printPostOrder(node.left);
         printPostOrder(node.right);
         System.out.print(node.data+",");
      }
   }

   @Override
   public void printLevelOrder() {
      Node<E> current = root;
      if(current ==  null)
         return;
      Queue<Node<E>> queue = new LinkedList<>();
      queue.add(current);
      while (!queue.isEmpty()){
         Node<E> node = queue.remove();
         if(node.left != null)
            queue.add(node.left);
         if(node.right != null)
            queue.add(node.right);
         System.out.print(node.data+",");
      }
   }

   @Override
   public boolean findNode(E key) {
      return findNode(root,key);
   }
   private boolean findNode(Node<E> node,E key){
      if(node != null){
         if(key.compareTo(node.data) == 0){
            return true;
         }else if(key.compareTo(node.data) < 0){
            return findNode(node.left,key);
         }else{
            return findNode(node.right,key);
         }
      }
      return false;
   }
}
