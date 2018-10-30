package com.chandan.designpatterns.strategy.simduckgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chandan on 26/10/18.
 */
public class TextSplit1 {

   static int countSplits(String message, int charLimit) {

      return splitSMS(message, charLimit);
   }

   static int splitSMS(String message, int charLimitOriginal) {
      if (message == null || message.length() == 0) {
         return 0;
      } else if (message.length() <= charLimitOriginal) {
         return 1;
      }
      int charLimit = charLimitOriginal - 5;
      ArrayList<String> result = new ArrayList<String>();
      String[] splitted = message.split(" ");
      String temp;

      for (int i = 0; i < splitted.length - 1; i++) {
         temp = splitted[i];
         while ((temp + 1 + splitted[i + 1]).length() <= charLimit && i + 1 < splitted.length - 1) {  //+1 for space
            temp = temp + " " + splitted[i + 1];
            i++;
         }
         result.add(temp);

      }
      String lastElement = result.get(result.size() - 1);
      if (lastElement.length() + 1 + splitted[splitted.length - 1].length() < charLimit) {  //+1 for space

         result.set(result.size() - 1, lastElement + " " + splitted[splitted.length - 1]);
      } else {
         result.add(splitted[splitted.length - 1]);
      }

      int resultSize = result.size();
      for (int i = 0; i < resultSize; i++) {
         result.set(i, result.get(i) + "(" + (i + 1) + "/" + resultSize + ")");
      }


      return result.size();
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int charLmit = 30;
      while (true){
         String message = sc.nextLine();
         if(message ==  null || message.length() == 0)
            break;
         System.out.println(countSplits(message, charLmit));
      }
   }
}