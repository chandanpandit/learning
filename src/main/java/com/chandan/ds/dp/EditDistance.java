package com.chandan.ds.dp;

/**
 * Created by chandan on 22/3/18.
 */
public class EditDistance {
   static int min(int x,int y,int z)
   {
      if (x <= y && x <= z) return x;
      if (y <= x && y <= z) return y;
      else return z;
   }

   static int editDistDP(String str1, String str2, int m, int n)
   {
      // Create a table to store results of subproblems
      int dp[][] = new int[m+1][n+1];

      // Fill d[][] in bottom up manner
      for (int i=0; i<=m; i++)
      {
         for (int j=0; j<=n; j++)
         {
            // If first string is empty, only option is to
            // isnert all characters of second string
            if (i==0)
               dp[i][j] = j;  // Min. operations = j

               // If second string is empty, only option is to
               // delete all characters of second string
            else if (j==0)
               dp[i][j] = i; // Min. operations = i

               // If last characters are same, ignore last char
               // and recur for remaining string
            else if (str1.charAt(i-1) == str2.charAt(j-1))
               dp[i][j] = dp[i-1][j-1];

               // If last character are different, consider all
               // possibilities and find minimum
            else
               dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                  dp[i-1][j],  // Remove
                                  dp[i-1][j-1]); // Replace
         }
      }

      for (int i = 0; i <= n; i++) {
         for (int j = 0; j <= m; j++) {
            System.out.print(dp[j][i]+" ");
         }
         System.out.println();
      }

      return dp[m][n];
   }

   static int count( int S[], int m, int n )
   {
      // table[i] will be storing the number of solutions for
      // value i. We need n+1 rows as the table is constructed
      // in bottom up manner using the base case (n = 0)
      int[] table = new int[n+1];

      // Initialize all table values as 0
      for (int i = 0; i <= n; i++) {
         table[i] = 0;
      }

      // Base case (If given value is 0)
      table[0] = 1;

      // Pick all coins one by one and update the table[] values
      // after the index greater than or equal to the value of the
      // picked coin
      for(int i=0; i<m; i++) {
         for (int j = S[i]; j <= n; j++)
            table[j] += table[j - S[i]];
         System.out.print("\nTable -> ");
         for (int num : table){
            System.out.print(num + " ");
         }
      }

      return table[n];
   }


   public static void main(String args[])
   {
     /* String str1 = "sunday";
      String str2 = "saturday";
      System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );*/
      int arr[] = {1, 2, 3};
      int m = arr.length;
      int n = 4;
      System.out.println(count(arr, m, n));
   }
}