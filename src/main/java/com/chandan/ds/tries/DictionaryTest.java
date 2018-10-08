package com.chandan.ds.tries;

import java.io.*;
import java.util.List;

public class DictionaryTest {
   private static final String ENGLISH_DICTIONARY_PATH = "/home/chandan/workspaces/learning/MOOCTextEditor/data/words.small.txt";

   public static void main(String[] args) {
      Dictionary dictionary = new Tries();
      long start = System.currentTimeMillis();
      int totalWords = loadEnglishDictionary(dictionary);
      System.out.println("Dictionary Built. \nTotal Words : "+totalWords+"\nTime : "+(System.currentTimeMillis()-start)+"ms");
      dictionary.addWord("hunter");
      /*String[] words = {"am", "chandan", "chance", "dog", "car", "america", "agon"};
      for (int i = 0; i < words.length; i++) {
         dictionary.addWord(words[i]);
      }*/
      SpellSuggestion spellSuggestor = (Tries) dictionary;
      String prefix = "hun";
      start = System.nanoTime();
      List<String> suggestions = spellSuggestor.suggestWords(prefix);
      System.out.println("Time to suggest = "+(double)(System.nanoTime()-start)/1000000+"ms");
      System.out.println("Suggestion for prefix = " + prefix);
      for (int i = 0; i < suggestions.size(); i++) {
         System.out.println(suggestions.get(i));
      }
   }

   public static int loadEnglishDictionary(Dictionary dictionary) {
      File file = new File(ENGLISH_DICTIONARY_PATH);
      BufferedReader br;
      int totalWords = 0;
      try {
         br = new BufferedReader(new FileReader(file));
         String st;
         while ((st = br.readLine()) != null) {
            totalWords++;
            dictionary.addWord(st);
         }
      } catch (FileNotFoundException e) {
         System.out.println("Input file not found");
      } catch (IOException e) {
         System.out.println("Error in reading file");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return totalWords;
   }
}
