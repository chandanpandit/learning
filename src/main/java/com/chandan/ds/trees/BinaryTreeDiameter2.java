package com.chandan.ds.trees;


// A utility class to pass heigh object
class Height
{
   int h;
}


/* Class to print the Diameter */
public class BinaryTreeDiameter2
{
   static class Node
   {
      int data;
      Node left, right;

      public Node(int item)
      {
         data = item;
         left = right = null;
      }
   }
   Node root;

   /* define height =0 globally and  call diameterOpt(root,height)
      from main */
   int diameterOpt(Node root, Height height)
   {
        /* lh --> Height of left subtree
           rh --> Height of right subtree */
      Height lh = new Height(), rh = new Height();

      if (root == null)
      {
         height.h = 0;
         return 0; /* diameter is also 0 */
      }

        /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */
        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
      lh.h++;     rh.h++;
      int ldiameter = diameterOpt(root.left, lh);
      int rdiameter = diameterOpt(root.right, rh);

        /* Height of current node is max of heights of left and
         right subtrees plus 1*/
      height.h = Math.max(lh.h, rh.h) + 1;

      return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
   }

   /* A wrapper over diameter(Node root) */
   int diameter()
   {
      Height height = new Height();
      return diameterOpt(root, height);
   }

   /*The function Compute the "height" of a tree. Height is the
     number f nodes along the longest path from the root node
     down to the farthest leaf node.*/
   static int height(Node node)
   {
        /* base case tree is empty */
      if (node == null)
         return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
      return (1 + Math.max(height(node.left), height(node.right)));
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

   public static void main(String args[])
   {
        /* creating a binary tree and entering the nodes */
      BinaryTreeDiameter2 tree = new BinaryTreeDiameter2();
      /*tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);*/
      tree.insert(30);
      tree.insert(15);
      tree.insert(8);
      tree.insert(20);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      tree.insert(11);

      System.out.println("The diameter of given binary tree is : "
                         + tree.diameter());
   }
}