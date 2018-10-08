package com.chandan.ds.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chandan on 21/9/18.
 * Ref : https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
 */
public class ParenthesisChecker {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String s = sc.next();
         boolean isBalanced = isBalanced(s);
         String output = isBalanced ? "balanced" : "not balanced";
         System.out.println(output);
         sc.nextLine();
      }
   }

   private static boolean isBalanced(String s) {
      Stack<Character> stack = new Stack<>();
      for (Character c : s.toCharArray()) {
         switch (c) {
            case '[':
            case '{':
            case '(':
               stack.push(c);
               break;
            case ']':
               if (stack.isEmpty() || stack.pop() != '[') {
                  return false;
               }
               break;
            case '}':
               if (stack.isEmpty() || stack.pop() != '{') {
                  return false;
               }
               break;
            case ')':
               if (stack.isEmpty() || stack.pop() != '(') {
                  return false;
               }
               break;
         }
      }
      return stack.isEmpty();
   }
}