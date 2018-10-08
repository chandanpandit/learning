package com.chandan.ds.string;


import java.util.Stack;

public class SameExpressions {
   public static void main(String[] args) {
      String s1 = "a-b-((c-d))";
      String s2 = "a-c+d-b";
      if (areSame(s1.toCharArray(), s2.toCharArray())) {
         System.out.println("SAME");
      }else {
         System.out.println("NOT SAME");
      }
   }

   static boolean areSame(char[] s1, char[] s2){
      int[] count = new int[26]; // will store the sign  of ith char
      eval(s1,count,true);
      eval(s2,count,false);
      for (int i = 0; i < 26 ; i++) {
         if(count[i] != 0)
            return false;
      }
      return true;
   }

   private static void eval(char[] expr, int[] count, boolean add) {
      if(expr.length == 0)
         return;
      Stack<Boolean> stack = new Stack<>();
      stack.push(true);
      for (int i = 0; i < expr.length; i++) {
         if(expr[i] == '+' || expr[i] == '-')
            continue;
         if(expr[i] == '('){
            if(getLocalSign(expr,i)){
               stack.push(stack.peek());
            }else{
               stack.push(!stack.peek());
            }
         }else if(expr[i] == ')'){
            stack.pop();
         }else{
            if(stack.peek()){ // global sign is positive
               count[expr[i] - 'a'] += getLocalSign(expr,i) ? (add ? 1 : -1) : (add ? -1 : 1);
            }else { // global sign is negative
               count[expr[i] - 'a'] += getLocalSign(expr,i) ? (add ? -1 : 1) : (add ? 1 : -1);
            }
         }
      }
   }

   private static boolean getLocalSign(char[] s, int i){
      if(i == 0)
         return true;
      else if(s[i-1] == '-')
         return false;
      return true;
   }
}