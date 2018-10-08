package com.chandan.ds.tries;

import java.util.List;

public interface SpellSuggestion {
   List<String> suggestWords(String prefix,int maxNumSuggestion);
   List<String> suggestWords(String prefix);
}
