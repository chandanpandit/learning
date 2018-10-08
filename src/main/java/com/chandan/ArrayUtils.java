package com.chandan;


public class ArrayUtils {
   public static void printArray(String label,int[] a){
      System.out.print(label + " : ");
      printArray(a);
   }
   public static void printArray(int[] a){
      System.out.print("[");
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i]+",");
      }
      System.out.println("]");
   }
}