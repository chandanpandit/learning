package com.chandan.java8features;

import java.util.Arrays;
import java.util.List;

public class SerialVsParallel {
   public static void main(String[] args) {
      List<String> strings = Arrays.asList("A", "B", "C", "D");
      long start = System.currentTimeMillis();
      strings.stream().forEach(SerialVsParallel::taskOne);
      long end = System.currentTimeMillis();
      System.out.println(end - start);
   }

   static void taskOne(String s) {
      try {
         Thread.sleep(1000);
         System.out.println(s + " Done!");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}