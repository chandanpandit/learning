package com.chandan.ds.dp;

/**
 * Created by chandan on 21/11/17.
 */
public class Acode {
   private static int arrange(String s,int start,int len){
      if(start == len){
         return 1;
      }
      if(s.charAt(start) == '0'){
         return 0;
      }
      int count = 0;
      if(start < len){
         int oneLength = Integer.parseInt(s.substring(start,start+1));
         if(oneLength >= 1 && oneLength <= 26){
            count += arrange(s,start+1,len);
         }
      }
      if(start < len - 1){
         int twoLength = Integer.parseInt(s.substring(start,start+2));
         if(twoLength >= 1 && twoLength <= 26){
            count += arrange(s,start+2,len);
         }
      }

      return count;
   }
   public static void main(String[] args) {
      String s = "260";
      System.out.println(arrange(s, 0, s.length()));
   }
}
