package com.chandan.ds.string;

import java.util.HashMap;
import java.util.Map;

public class DocumentDistance {
    public static void main(String[] args) {
        String doc1 = "the cat is a domestic animal";
        String doc2 = "the lion is a wild animal";
        System.out.println(documentDistance(doc1, doc2));
    }

    /**
     * Shows how distant two documents are.
     * @param doc1
     * @param doc2
     * @return
     */
    private static double documentDistance(String doc1, String doc2) {
        if (doc1 == null || doc2 == null || doc1.length() == 0 || doc2.length() == 0)
            throw new RuntimeException("Invalid Input");
        String[] doc1Words = doc1.split(" ");
        String[] doc2Words = doc2.split(" ");
        Map<String, Integer> doc1WordCounts = new HashMap<>();
        for (String word : doc1Words) {
            int count = 0;
            if (doc1WordCounts.containsKey(word)) {
                count = doc1WordCounts.get(word);
            }
            count++;
            doc1WordCounts.put(word, count);
        }

        Map<String, Integer> doc2WordCounts = new HashMap<>();
        for (String word : doc2Words) {
            int count = 0;
            if (doc2WordCounts.containsKey(word)) {
                count = doc2WordCounts.get(word);
            }
            count++;
            doc2WordCounts.put(word, count);
        }

        long product = 0;

        for (String word : doc1WordCounts.keySet()) {
            int num1 = doc1WordCounts.getOrDefault(word, 0);
            int num2 = doc2WordCounts.getOrDefault(word, 0);
            product += num1 * num2;
        }

        return (double) product / (doc1Words.length * doc2Words.length);
    }
}
