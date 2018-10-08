package com.chandan.ds.array;

public class MaxDepthJson {
   public static void main(String[] args) {
      //String json = "{\"key\":{\"key\":\"val\"},\"key\":\"val\"}"; // output = 2
      String json = "[[[[]]]]"; // output = 4
      System.out.println(maxDepth(json));
   }

   // assumes
   private static int maxDepth(String json) {
      int maxDepth = 0, depth = 0;
      for (int i = 0; i < json.length(); i++) {
         char c = json.charAt(i);
         if(c == '[' || c == '{'){ // left bracket
            depth++;
         }else if(c == ']' || c == '}'){
            depth--;
         }
         maxDepth = Math.max(maxDepth,depth);
      }
      return maxDepth;
   }
}