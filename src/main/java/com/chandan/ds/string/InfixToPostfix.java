package com.chandan.ds.string;


import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {
   public static void main(String[] args) throws Exception {
      //String infix = "a+b*(c^d-e)^(f+g*h)-i";
      String infix = "x ^ y / (5 * z) + 10";
      System.out.println(convertToPostFix(infix));
   }

   /**
    * Description :
    * Scan each character and if character is :
    * i) Operand : append to result
    * ii) '(' : Push to stack
    * iii) ')' : Pop from stack until the '(' is encountered.
    * iv) Operator : Pop from stack until
    *
    * @param infix
    * @return
    * @throws Exception
    */
   static String convertToPostFix(String infix) throws Exception {
      StringBuilder sb = new StringBuilder();
      Stack<Character> stack = new Stack<>();
      for (char c : infix.toCharArray()) {
         if (isOperand(c)) {
            sb.append(c);
         } else if (c == '(') {
            stack.push(c);
         } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
               sb.append(stack.pop());
            }
            if (!stack.isEmpty() && stack.peek() != '(') {
               throw new Exception("Invalid Expression!");// brackets not balanced
            } else {
               stack.pop();
            }
         } else if (isOperator(c)) {
            while (!stack.isEmpty() && (precedence(c) <= precedence(stack.peek()))) {
               sb.append(stack.pop());
            }
            stack.push(c);
         }
      }

      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }

      return sb.toString();
   }

   private static boolean isOperand(char c) {
      return Character.isLetterOrDigit(c);
   }

   private static boolean isOperator(char c) {
      return Arrays.asList('+', '-', '*', '/', '^').contains(c);
   }

   // defines precedence of chars
   private static int precedence(char c) {
      switch (c) {
         case '+':
         case '-':
            return 1;
         case '*':
         case '/':
            return 2;
         case '^':
            return 3;
      }

      return -1;
   }
}