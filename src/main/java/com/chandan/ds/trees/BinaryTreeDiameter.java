package com.chandan.ds.trees;

/**
 * Created by chandan on 16/3/18.
 */
public class BinaryTreeDiameter {
   static class Node{
      int data;
      Node left;
      Node right;

      public Node(int data) {
         this.data = data;
      }
   }
   static class BinaryTree{
      Node root;
      int dia(){
         Dia d = new Dia();
         d.dia = 0;
         dia(root,d);
         return d.dia;
      }
      private int dia(Node node,Dia d){
         if(node == null)
            return 0;
         int left = dia(node.left,d);
         int right = dia(node.right,d);
         d.dia = (1+left+right) > d.dia ? (1+left+right) : d.dia;
         return left > right ? 1+left : 1+right;
      }

      void insert(int data){
         root = insert(root,data);
      }
      private Node insert(Node node,int data){
         if(node ==  null){
            node = new Node(data);
         }else if(data < node.data){
            node.left = insert(node.left,data);
         }else{
            node.right = insert(node.right,data);
         }
         return node;
      }
   }
   static class Dia{
      int dia;
   }
   public static void main(String[] args){
      BinaryTree tree = new BinaryTree();
      tree.insert(30);
      tree.insert(15);
      tree.insert(8);
      tree.insert(20);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      tree.insert(11);
      /*tree.insert(25);
      tree.insert(23);
      tree.insert(28);
      tree.insert(27);*/
      System.out.println("The diameter of given binary tree is : "
                         + tree.dia());
   }
}