package com.chandan.ds.string;

/**
 * Created by chandan on 5/4/18.
 */
public class RemoveDuplicatesReccursively {
   public static void main(String[] args) {
      String s = "qpaaaaadaaaaadprq";
      System.out.println(removeDuplicate(s));
   }
   public static String removeDuplicate(String s){
      if(s == null || s.length() == 1)
         return s;
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < s.length(); i++) {
         int c = 1;
         while (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
            c++;i++;
         }
         if(c == 1){
            sb.append(s.charAt(i));
         }
      }
      String newString = sb.toString();
      if(newString.length() == s.length())
         return s;
      return removeDuplicate(newString);
   }
}