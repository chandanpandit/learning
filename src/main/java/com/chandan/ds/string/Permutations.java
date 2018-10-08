package com.chandan.ds.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chandan on 23/9/18.
 * Ref : https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 */
public class Permutations {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         String input = sc.next();
         List<String> permutations = permute(input);
         for (int i = 0; i < permutations.size(); i++) {
            System.out.print(permutations.get(i) + " ");
         }
         System.out.println();
      }
   }

   public static List<String> permute(String input) {
      char[] inputChars = input.toCharArray();
      List<String> result = new ArrayList<>();
      permute(inputChars, 0, inputChars.length - 1, result);
      Collections.sort(result); // required for submitting solution.

      return result;
   }

   private static void permute(char[] inputChars, int l, int h, List<String> result) {
      if (l == h) {
         result.add(String.valueOf(inputChars));
      } else {
         for (int i = l; i <= h; i++) {
            swap(inputChars, l, i);
            permute(inputChars, l + 1, h, result);
            swap(inputChars, l, i);
         }
      }
   }

   private static void swap(char[] inputChars, int i, int j) {
      char c = inputChars[i];
      inputChars[i] = inputChars[j];
      inputChars[j] = c;
   }
}