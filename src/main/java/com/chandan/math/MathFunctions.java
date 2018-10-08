package com.chandan.math;

public class MathFunctions {

   public static void main(String[] args) throws Exception {
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            System.out.println(Math.pow(i, j) + "|" + power(i, j));
         }
      }
   }

   public static double sqrt(int number) throws Exception {
      if (number < 0) {
         throw new Exception("Negative numbers not supported");
      }
      if (number <= 1) {
         return number;
      }
      double t;

      double squareRoot = number / 2;

      do {
         t = squareRoot;
         squareRoot = (t + (number / t)) / 2;
         System.out.println(t + " | " + squareRoot);
      } while ((t - squareRoot) != 0);

      return squareRoot;
   }

   public static long power(int a, int b) {
      if (b == 0) {
         return 1;
      }
      if (b == 1) {
         return a;
      }
      if (b % 2 == 0) {
         return power(a * a, b / 2);
      } else {
         return a * power(a * a, b / 2);
      }
   }
}

