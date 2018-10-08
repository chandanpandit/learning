package com.chandan.ds.string;

import java.util.Scanner;

/**
 * Ref : https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 */
public class ReverseWords {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String input = sc.next();
         char[] charInput = input.toCharArray();
         System.out.println(reverseWords(charInput));
      }
   }

   private static String reverseWords(char[] charInput) {
      int start = 0;
      reverse(charInput, 0, charInput.length - 1);
      for (int i = 0; i < charInput.length; i++) {
         if (charInput[i] == '.') {
            reverse(charInput, start, i - 1);
            start = i + 1;
         } else if (i == charInput.length - 1) {
            reverse(charInput, start, i);
         }
      }
      return String.valueOf(charInput);
   }

   private static void reverse(char[] charInput, int i, int j) {
      while (i < j) {
         char temp = charInput[i];
         charInput[i] = charInput[j];
         charInput[j] = temp;
         i++;
         j--;
      }
   }
}