package com.chandan.ds.dp;

/**
 * Created by chandan on 25/11/17.
 */
// LongestCommonSub-sequence
public class LongestCommonSubsequence {

   public static int lcs(String s1, String s2){
      int l1 = s1.length();
      int l2 = s2.length();
      int[][] lcs = new int[l1+1][l2+1];
      for (int i = 0; i <= l1; i++) {
         for (int j = 0; j <= l2; j++) {
            if(i == 0 | j == 0){
               lcs[i][j] = 0;
            }else if(s1.charAt(i-1) == s2.charAt(j-1)){
               lcs[i][j] = 1 + lcs[i-1][j-1];
            }else {
               lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
         }
      }

      int i = l1,j=l2;
      StringBuilder sb = new StringBuilder();
      while (i > 0 && j > 0){
         if(s1.charAt(i-1) == s2.charAt(j-1)){
            sb.append(s1.charAt(i-1));
            i--;
            j--;
         }else if(lcs[i-1][j] > lcs[i][j-1]){
            i--;
         }else{
            j--;
         }
      }
      System.out.println(sb.reverse());

      return lcs[l1][l2];
   }
   public static void main(String[] args) {
      String s1 = "ABCDGH";
      String s2= "AEDFHR";
      System.out.println(lcs(s2,s1));
   }
}
