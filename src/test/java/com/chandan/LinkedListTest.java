package com.chandan;

import com.chandan.ds.linkedlist.LinkedList;
import com.chandan.ds.linkedlist.MySLLinkedList;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;


public class LinkedListTest {
   private LinkedList<Integer> mylist;
   @Before
   public void setup(){
      mylist = new MySLLinkedList<>();
      System.out.println("Before");
   }

   @BeforeClass
   public static void beforeClass(){
      System.out.println("BeforeClass");
   }

   @Test
   public void testIsEmpty(){
      assertEquals(true,mylist.isEmpty());
      mylist.add(1);
      assertEquals(false,mylist.isEmpty());
   }

   @Test
   public void testAdd(){
      mylist.add(1);
      assertEquals(1,mylist.size());
      assertEquals(true,mylist.contains(1));
   }

   @Test
   public void testContains(){
      mylist.add(1);
      assertEquals(true,mylist.contains(1));
      assertEquals(false,mylist.contains(2));
   }

   @Test
   public void testRemove(){
      mylist.add(1);
      mylist.add(2);
      mylist.remove(1);
      assertEquals(false,mylist.contains(1));
      assertEquals(1,mylist.size());
   }

   @Test
   public void testGet(){
      try{
         mylist.get(0);
         fail("Index out of bounds");
      }catch (IndexOutOfBoundsException e){

      }
      mylist.add(1);
      mylist.add(2);
      assertEquals((Integer) 2,(Integer)mylist.get(1));
      assertNotSame((Integer) 1,(Integer)mylist.get(1));
      try {
         mylist.get(5);
      }catch (IndexOutOfBoundsException e){

      }
   }

   @After
   public void tearDown(){
      System.out.println("After");
   }

   @AfterClass
   public static void afterClass(){
      System.out.println("AfterClass");
   }
}
