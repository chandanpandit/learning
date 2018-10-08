package com.chandan.innerclasses;

public class LocalClassTest {
   public static void main(String[] args) {
      Outer outer = new Outer();
      //outer.outerTest();
      outer.testLocalClass();
   }
}

class Outer {
   private String name = "Outer";

   class InnerClass {
      private String name = "Inner";

      public void test() {
         System.out.println(name);
      }
   }

   public void outerTest() {
      System.out.println(name);
      new InnerClass().test();
   }

   public void testLocalClass(){
      int x = 10;
      String name = "Chandan";
      class LocalClass{
         void test(){
            System.out.println("Local Test"+x+name);
         }
      }

      LocalClass localClass = new LocalClass();
      localClass.test();
   }
}
