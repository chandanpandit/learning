package com.chandan.ds.array;


public class EncodeDecode {
   public static void main(String[] args) {
      String s = "My name is chandan";
      System.out.println(s);
      System.out.println(encode(s));
   }


   static String encode(String s) {
      char[] a = s.toCharArray();
      int i = 0, j = a.length - 1;
      while (i < j) {
         if (a[i] == ' ') {
            i++;
         } else if (a[j] == ' ') {
            j--;
         } else {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
         }

      }

      return String.valueOf(a);
   }
}