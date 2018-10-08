package com.chandan.ds.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonStrings {

   public static void main(String[] args) {
      char[] a = "chandan pandit is a good guy".toCharArray();
      char[] b = "chandan pandit good ram".toCharArray();
      List<char[]> result = findCommon(a,b);
      for (char[] word : result){
         System.out.println(String.valueOf(word));
      }
   }

   static List<char[]> findCommon(char[] a, char[] b){

      List<char[]> result = new ArrayList<>();
      Set<char[]> set = new HashSet<>();

      List<char[]> sentence1Words = getWords(a);

      for(char[] word : sentence1Words){
         set.add(word);
      }
      List<char[]> sentence2Words = getWords(b);
      for (char[] word : sentence2Words){
         if(set.contains(word)){
            result.add(word);
         }
      }

      return result;
   }

   // returns list of words in a sentence
   static List<char[]> getWords(char[] sentence){
      List<char[]> result = new ArrayList<>();
      int m = sentence.length;
      int i = 0;
      while(i < m){
         int start = i;
         int len = 0;
         while(i < m && sentence[i] != ' '){
            len++;i++;
         }
         if(len > 0){
            char[] word = new char[len];
            for(int j = start; j <i; j++ ){
               word[j-start] = sentence[j];
            }
            result.add(word);
         }
         // assuming only one space in sentence
         i++;
      }

      return result;
   }
}