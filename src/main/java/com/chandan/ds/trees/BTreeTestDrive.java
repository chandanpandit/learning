package com.chandan.ds.trees;

public class BTreeTestDrive {
   public static void main(String[] args) {
      BTree<Integer> bTree = new BinaryTree<>();
      System.out.println(bTree.findNode(1));
      bTree.insertNode(5);
      bTree.insertNode(3);
      bTree.insertNode(10);
      bTree.insertNode(4);
      bTree.insertNode(2);
      bTree.insertNode(7);
      bTree.insertNode(15);
      bTree.printPreOrder();
      System.out.println();
      bTree.printInOrder();
      System.out.println();
      bTree.printPostOrder();
      System.out.println();
      bTree.printLevelOrder();
   }
}
