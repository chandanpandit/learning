package com.chandan.ds;

import java.util.List;
import java.util.Scanner;

/**
 * Created by chandan on 16/3/18.
 */
public class HackerEarth {


   public static void main(String[] args) {


      Scanner s = new Scanner(System.in);

      // Get L and R from the input
      int L = s.nextInt();
      int R = s.nextInt();

      // Write here the logic to print all integers between L and R

      for (int i = L; i <= R; i++) {
         System.out.print(i + " ");
      }


      s.close();

   }

}