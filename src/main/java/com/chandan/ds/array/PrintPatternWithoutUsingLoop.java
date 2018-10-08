package com.chandan.ds.array;

/**
 * Created by chandan on 25/9/18.
 */
public class PrintPatternWithoutUsingLoop {
   public static void main(String[] args) {
      print(10);
   }

   static void print(int n) {  // true -> down, false-> up
      System.out.print(n + ", ");
      if (n > 0) {
         print(n - 5);
      } else {
         return;
      }
      System.out.print(n + ", ");
   }
}