package com.chandan.ds.tries;

import java.util.*;

public class Tries implements Dictionary, SpellSuggestion{
   private TrieNode root;
   private static final int MAX_NUMBER_OF_SUGGESTION = 10;

   public Tries() {
      root = new TrieNode();
   }

   @Override
   public void addWord(String word) {
      char[] characters = word.toCharArray();
      TrieNode temp = root;
      for (int i = 0; i < characters.length; i++) {
         if(!temp.children.containsKey(characters[i])){
            temp.children.put(characters[i],new TrieNode());
         }
         temp = temp.children.get(characters[i]);
      }
      temp.word = word;
      temp.isWord = true;
   }

   @Override
   public boolean isWord(String word) {
      char[] characters = word.toCharArray();
      int i = 0;
      TrieNode temp = root;
      while (i < characters.length){
         if(!temp.children.containsKey(characters[i])){
            return false;
         }
         temp = temp.children.get(characters[i]);
         i++;
      }

      return temp.isWord;
   }

   @Override
   public List<String> suggestWords(String prefix) {
      return suggestWords(prefix,MAX_NUMBER_OF_SUGGESTION);
   }

   @Override
   public List<String> suggestWords(String prefix,int maxNumSuggestion) {
      char[] characters = prefix.toCharArray();
      // move till all chars in prefix
      TrieNode temp = root;
      int i = 0;
      while (i < characters.length){
         if(!temp.children.containsKey(characters[i])){
            return Collections.emptyList();
         }
         temp = temp.children.get(characters[i]);
         i++;
      }
      List<String>  suggestions = new ArrayList<>();
      Queue<TrieNode> queue = new LinkedList<>();
      queue.add(temp);
      int count = 0;
      while (!queue.isEmpty() && count < maxNumSuggestion){
         TrieNode current = queue.remove();
         if(current.isWord){
            suggestions.add(current.word);
            count++;
         }
         Set<Character> entrySet = current.children.keySet();
         for (Character c:entrySet) {
            queue.add(current.children.get(c));
         }
      }

      return suggestions;
   }
}
