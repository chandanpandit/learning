package com.chandan.ds.dp;

/**
 * Created by chandan on 28/11/17.
 */
public class LongestRepeatedSubsequence {
   private static String longestRepeatedSubsequence(String s){
      int n = s.length();
      int[][] dp = new int[n+1][n+1];
      for (int i = 0; i <= n; i++) {
         for (int j = 0; j <= n; j++) {
            if(i == 0 || j == 0){
               dp[i][j] = 0;
            }else if(s.charAt(i-1) == s.charAt(j-1) && i != j){
               dp[i][j] = 1 + dp[i-1][j-1];
            }else{
               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
         }
      }
      int i = n,j= n;
      int index = dp[n][n];
      char[] result = new char[index];
      while (i > 0 && j > 0){
         if(i != j && s.charAt(i-1) == s.charAt(j-1)){
            result[--index] = s.charAt(i-1);
            i--;
            j--;
         } else if( dp[i-1][j] > dp[i][j-1] ){
            i--;
         }else{
            j--;
         }
      }

      return String.valueOf(result);
   }
   public enum Elvis{
      INSTANCE;
      private String value;
      public String getValue(){
         return value;
      }
      public void setValue(String s){
         value = s;
      }
   }
   public static void main(String[] args) {
      String s = "aabebcdd";
      //System.out.println(longestRepeatedSubsequence(s));
      Elvis.INSTANCE.setValue("Chandan");
      System.out.println(Elvis.INSTANCE.getValue());
   }
}
