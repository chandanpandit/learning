package com.chandan.ds.dp;

import java.util.Scanner;

/**
 * Created by chandan on 23/9/18.
 * Ref : https://practice.geeksforgeeks.org/problems/tom-and-jerry/0
 */
public class OptimalStrategyForAGame {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int N = sc.nextInt();
         boolean res = play(N, true); // true means tom's turn, false -> jerry's turn
         System.out.println(res ? 1 : 0);
      }
   }

   private static boolean play(int n, boolean turn) {
      if (n == 1) {
         return !turn;
      }

      if(turn) {
         for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
               if(play(n - i, !turn)) return true;
            }
         }

         return false;
      }else{
         for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
               if(!play(n - i, !turn)) return false;
            }
         }

         return true;
      }
   }
}