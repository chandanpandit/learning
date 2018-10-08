package com.chandan.java8features;


public interface Vehicle {
   static void staticMethod(){
      System.out.println("Vehicle Static");
   }

   default void defaultMethod(){
      staticMethod();
      System.out.println("Default Method");
   }
}
