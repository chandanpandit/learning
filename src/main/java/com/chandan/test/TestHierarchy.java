package com.chandan.test;

/**
 * Created by chandan on 14/10/18.
 */
public class TestHierarchy {
   public static void main(String[] args) {
      A a = new B("Chandan");
      System.out.println(a.getName("Chandan"));
   }
}

class A {
   protected String name;

   public A(String name) {
      this.name = name;
   }

   protected Object getName(String name) {
      System.out.println("A Called");
      return name;
   }
}

class B extends A {
   public B(String name) {
      super(name);
   }

   protected String getName(String... names) {
      System.out.println("B Called");
      return name;
   }

}