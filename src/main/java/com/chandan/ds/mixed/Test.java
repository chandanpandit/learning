package com.chandan.ds.mixed;

class A{
   public static void X(){
      Y();
   }
   public static void Y(){
      System.out.println("I am Parent");
   }
}
class B extends A{
   public static void X(){
      System.out.println("I am Child");
   }
}
public class Test {
   public static void main(String[] args) {
      A a = new A();
      a.X();
      B b = new B();
      b.X();
      A ba = new B();
      ba.X();

   }
}