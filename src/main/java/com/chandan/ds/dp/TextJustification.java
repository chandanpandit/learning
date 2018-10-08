package com.chandan.ds.dp;


import java.util.Arrays;
import java.util.List;

public class TextJustification {
   private static final int PAGE_WIDTH = 30;
   private static final int INFINITY = 100000;

   public static void main(String[] args) {
      //List<String> words = Arrays.asList("Siri","is","a","spin-off","from","a","project","originally","developed","by","the","SRI","International","Artificial","Intelligence","Center.","Its","speech","recognition","engine","was","provided","by","Nuance","Communications,","and","Siri","uses","advanced","machine","learning","technologies","to","function.","Its","original","American,","British,","and","Australian","voice","actors","recorded","their","respective","voices","around","2005,","unaware","of","the","recordings'","eventual","usage","in","Siri.","The","voice","assistant","was","released","as","an","app","for","iOS","in","February","2010,","and","it","was","acquired","by","Apple","two","months","later.","Siri","was","then","integrated","into","iPhone","4S","at","its","release","in","October","2011.","At","that","time,","the","separate","app","was","also","removed","from","the","iOS","App","Store.","Siri","has","become","an","integral","part","of","Apple's","products,","having","been","adapted","into","other","hardware","devices","over","the","years,","including","newer","iPhone","models,","as","well","as","iPad,","iPod","Touch,","Mac,","AirPods,","Apple","TV","and","HomePod");
      List<String> words = Arrays.asList("Siri","is","a","spin-off","from","a","project","originally","developed","by","the","SRI","International","Artificial");
      String justified = justify(words);
      System.out.println("Justified :: for line width = "+PAGE_WIDTH);
      System.out.println(justified);
   }

   private static String justify(List<String> words) {
      int n = words.size();
      int[] parent = new int[n];
      Arrays.fill(parent,-1);
      int minBad = findMinBad(words,0,parent);
      System.out.println("MinBad = "+minBad);

      String result = "";
      int curr = 0;
      while (curr < n && parent[curr] >= 0){
         int next = parent[curr];
         String line = "";
         for (int i = curr > 0 ? curr+1 : curr ; i <= next; i++) {
            line += words.get(i)+" ";
         }
         result += line + "\n";
         curr = next;
      }

      return result;
   }

   private static int findMinBad(List<String> words, int i,int[] parent) {
      int n = words.size();
      if(i == n-1) // including all left words do not cost
         return 0;
      int minBad = INFINITY;
      for (int j = i+1; j < n; j++) {
         int cost = findMinBad(words,j,parent) + badness(words,i,j);
         if(cost < minBad){
            minBad = cost;
            parent[i] = j;
         }
      }

      return minBad;
   }

   private static int badness(List<String> words,int i,int j){
      int totalLength = 0;
      for (int k = i; k <= j; k++){
         totalLength += words.get(k).length();
      }
      totalLength += j-i; // spaces
      int badness = INFINITY;
      if(totalLength <= PAGE_WIDTH)
         badness = (PAGE_WIDTH - totalLength) * (PAGE_WIDTH - totalLength) * (PAGE_WIDTH - totalLength);
      return badness;
   }

   private static void printArray(int[] a){
      System.out.print("[");
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i]+",");
      }
      System.out.println("]");
   }

}