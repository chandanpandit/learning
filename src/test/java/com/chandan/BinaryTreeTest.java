package com.chandan;

import com.chandan.ds.trees.BTree;
import com.chandan.ds.trees.BinaryTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BinaryTreeTest {
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   BTree<Integer> emptyTree;
   BTree<Integer> bTree;
   BTree<Character> characterBTree;

   @Before
   public void setup(){
      System.out.println("Setting Up for Test Case");
      emptyTree = new BinaryTree<>();
      bTree = new BinaryTree<>();
      bTree.insertNode(5);
      bTree.insertNode(3);
      bTree.insertNode(10);
      bTree.insertNode(4);
      bTree.insertNode(2);
      bTree.insertNode(7);
      bTree.insertNode(15);
      // set system out/error to our custom buffers
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
   }

   @Test
   public void findNode(){
      assertEquals(emptyTree.findNode(4),false);
      assertEquals(bTree.findNode(3),true);
      assertEquals(bTree.findNode(11),false);
   }

   @Test
   public void testPreOrder(){
      bTree.printPreOrder();
      assertEquals(outContent.toString(),"5,3,2,4,10,7,15,");
   }

   @Test
   public void testPostOrder(){
      bTree.printPostOrder();
      assertEquals(outContent.toString(),"2,4,3,7,15,10,5,");
   }

   @Test
   public void testInOrder(){
      bTree.printInOrder();
      assertEquals(outContent.toString(),"2,3,4,5,7,10,15,");
   }

   @Test
   public void testLevelOrder(){
      bTree.printLevelOrder();
      assertEquals(outContent.toString(),"5,3,10,2,4,7,15,");
   }



   @Test
   public void testInsert(){
      bTree.insertNode(27);
      assertEquals(bTree.findNode(27),true);
      bTree.printInOrder();
      assertEquals(outContent.toString(),"2,3,4,5,7,10,15,27,");
   }

   @Test
   public void testCharTreeCreate(){
      characterBTree = new BinaryTree<>();
      characterBTree.insertNode('K');
      characterBTree.insertNode('D');
      characterBTree.insertNode('P');
      characterBTree.insertNode('A');
      characterBTree.insertNode('F');
      characterBTree.insertNode('Y');
      characterBTree.insertNode('M');
      characterBTree.printInOrder();
      assertEquals(outContent.toString(),"A,D,F,K,M,P,Y,");
   }


   @After
   public void tearDown(){
      //reset system output stream & error to error
      System.setOut(System.out);
      System.setErr(System.err);
      System.out.println("Winding up Test Case");
   }
}
