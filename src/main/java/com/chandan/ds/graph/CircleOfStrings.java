package com.chandan.ds.graph;

import java.util.*;

public class CircleOfStrings {
   public static void main(String[] args) {
      //String[] a = {"for", "geek", "rig", "kaf"};
      //String[] a = {"abc", "bcd", "cdf"};
      //String[] a = {"ab", "bc", "cd", "da"};

      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0){
         int n = sc.nextInt();
         sc.nextLine();
         String[] a = sc.nextLine().split(" ");
         //boolean isCircle = isCircle(a);
         boolean isCircle = canBeChained(a);
         System.out.println(isCircle ? "1" : "0");
         t--;
      }
   }

   public static boolean isCircle(String[] a) {
      Set<Integer> set = new HashSet<>();
      set.add(0); // add first element
      return isCircle(a,set,0); // set first element as top
   }

   private static boolean isCircle(String[] a, Set<Integer> set, int last) {

      // check if  all elements used and it is a circle
      if(set.size() == a.length && a[0].charAt(0) == a[last].charAt(a[last].length() - 1))
         return true;

      for (int i = 0; i < a.length; i++) {
         // not already included and starts with the last element's last char
         if(!set.contains(i) && a[last].charAt(a[last].length() - 1) == a[i].charAt(0)){
            set.add(i);
            if(isCircle(a,set,i)) {
               return true;
            }else{ // backtrack
               set.remove(i);
            }
         }
      }

      return false;
   }

   public static boolean canBeChained(String[] str){
      Map<Character,String> M = new LinkedHashMap<>(str.length);
      Map <Character,Integer> V = new LinkedHashMap<>(str.length);
      for(int i = 0;i<str.length;i++){
         M.put(str[i].charAt(0),str[i]);
         V.put(str[i].charAt(0),0);
      }
      char first = str[0].charAt(0);
      dfs(M,first,V);
      Boolean toRet = true;
      for(Character key: V.keySet()){
         Integer val = V.get(key);
         if(val == 0) return false;
      }
      return true;

   }

   public static void dfs(Map<Character,String> M,Character n,Map<Character,Integer> visited){
      if(visited.get(n) != null &&  visited.get(n) == 1)
         return;
      visited.put(n,1);
      Character nextNode = M.get(n).charAt(M.get(n).length() - 1);
      dfs(M,nextNode,visited);
   }
}