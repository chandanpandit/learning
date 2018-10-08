package com.chandan.ds.stack;

import java.util.Stack;

/**
 * Created by chandan on 28/9/18.
 */
public class ReverseContentOfStack {
   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < 5; i++) {
         stack.push(i);
      }
      reverse(stack);
      while (!stack.isEmpty()) {
         System.out.println(stack.pop() + " ");
      }
   }

   private static void reverse(Stack<Integer> stack) {
      if (stack.isEmpty()) {
         return;
      }
      int elem = stack.pop();
      reverse(stack);
      insertAtBottom(stack, elem);
   }

   private static void insertAtBottom(Stack<Integer> stack, int elem) {
      if (stack.isEmpty()) {
         stack.push(elem);
      } else {
         int poppedItem = stack.pop();
         insertAtBottom(stack, elem);
         stack.push(poppedItem);
      }
   }
}