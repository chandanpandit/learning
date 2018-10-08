package com.chandan.ds.array;

/**
 * Created by chandan on 5/5/18.
 */
public class FirstPositiveInteger {
   public static void main(String[] args) {
      int[]  a = {12,0,-7,4,-8,1,2,7,3,10};
      //System.out.println(getFirstPositiveInteger(a));
      System.out.println(firstPositiveMissingNumber(a));

   }
   static boolean fun1(){
      System.out.println("Fun 1");
      return true;
   }

   static boolean fun2(){
      System.out.println("Fun 2");
      return true;
   }

   public static int getFirstPositiveInteger(int[] a){
      int max = 0;
      for (int i = 0; i < a.length; i++) {
         if(a[i] > 0 && (max == 0 || a[i] < max)){
            max = a[i];
         }
      }
      return max;
   }

   public static int firstPositiveMissingNumber(int[] a){
      int n = a.length;
      boolean[] b = new boolean[n];
      for(int i = 0; i<n; i++){
         if(a[i] > 0 & a[i] < n)
            b[a[i]] = true;
      }
      for(int i = 1; i < n; i++){
         if(b[i] == false){
            return i;
         }
      }
      return n;
   }
}