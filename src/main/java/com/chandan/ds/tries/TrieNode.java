package com.chandan.ds.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
   String word;
   boolean isWord;
   Map<Character,TrieNode> children;

   public TrieNode() {
      children = new HashMap<>();
   }
}
