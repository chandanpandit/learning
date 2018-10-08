package com.chandan.ds.dp;

import java.util.*;

public class CatalonNumber {

   public static void main(String[] args) {
      Map<Integer,Set<String>> map = new HashMap<>();
      System.out.println(arrange(8,map));
      for (Map.Entry entry : map.entrySet()) {
         System.out.println(entry.getKey()+"=>"+((Set)entry.getValue()).size()+" => "+entry.getValue());
      }
   }

   static int arrange(int n,Map<Integer,Set<String>> map){
      if(n < 1){
         map.put(0,new HashSet<>());
         return 0;
      }else if(n == 1){
         map.put(1,new HashSet<>(Arrays.asList("()")));
         return 1;
      }else{
         arrange(n-1,map);// arrange previous
         Set<String> lastPatterns = map.get(n-1);
         Set<String> currentPatterns = new HashSet<>();

         for (String pattern : lastPatterns){
            currentPatterns.add("()"+pattern); // prepend
            currentPatterns.add(pattern+"()"); // append
            currentPatterns.add("("+pattern+")"); // wrap
         }

         map.put(n,currentPatterns);
      }

      return map.get(n).size();
   }
}