package com.chandan.ds.string;

/**
 * Created by chandan on 11/6/18.
 */
public class RearrangeNotSameAdjacent {
   public static void rearrange(char[] s) throws Exception {
      int n = s.length;

      for (int i = 0; i < n-1; i++) {
         int j = i+1;
         while ( j < n && s[i] == s[j] ){
            j++;
         }
         if(j < n)
            swap(s,i+1,j);
      }
      // if last two chars are same it means we can't arrange
      System.out.println(s);
      if(s[n-1] == s[n-2])
         throw new Exception("Can't rearrange");
   }

   private static void swap(char[] s,int i,int j){
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
   }
   public static void main(String[] args) throws Exception {
      String  s = "aaaabcd";
      char[] arr = s.toCharArray();
      rearrange(arr);
      System.out.println(arr);

      System.out.println("----------------------------------");

      s = "aaabbbcc";
      arr = s.toCharArray();
      rearrange(arr);
      System.out.println(arr);
   }
}