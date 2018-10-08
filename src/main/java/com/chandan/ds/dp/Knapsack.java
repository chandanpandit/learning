package com.chandan.ds.dp;

class Knapsack
{

   // A utility function that returns maximum of two integers
   static int max(int a, int b) { return (a > b)? a : b; }

   // Returns the maximum value that can be put in a knapsack of capacity W
   static int knapSack(int W, int wt[], int val[], int n)
   {
      int i, w;
      int K[][] = new int[n+1][W+1];

      // Build table K[][] in bottom up manner
      for (i = 0; i <= n; i++)
      {
         for (w = 0; w <= W; w++)
         {
            if (i==0 || w==0)
               K[i][w] = 0;
            else if (wt[i-1] <= w)
               K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
            else
               K[i][w] = K[i-1][w];
         }
      }
      for (int j = 0; j <= n; j++) {
         for (int k = 0; k < W; k++) {
            System.out.print(K[j][k]+" ");
         }
         System.out.println();
      }
      return K[n][W];
   }

   private static int minJumps(int[] arr, int n) {
      int jumps[] = new int[n];  // jumps[n-1] will hold the
      // result
      int i, j;

      if (n == 0 || arr[0] == 0)
         return Integer.MAX_VALUE;  // if first element is 0,
      // end cannot be reached

      jumps[0] = 0;

      // Find the minimum number of jumps to reach arr[i]
      // from arr[0], and assign this value to jumps[i]
      for (i = 1; i < n; i++)
      {
         jumps[i] = Integer.MAX_VALUE;
         for (j = 0; j < i; j++)
         {
            System.out.println("i="+i+" j="+j+" arr[j]="+arr[j]);
            if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
            {
               jumps[i] = Math.min(jumps[i], jumps[j] + 1);
               break;
            }
         }
      }
      return jumps[n-1];
   }

   // driver program to com.chandan.test above function
   public static void main(String[] args) {
      int arr[] = {1, 3, 6, 1, 0, 9};

      System.out.println("Minimum number of jumps to reach end is : "+
                         minJumps(arr,arr.length));
   }


   /*// Driver program to com.chandan.test above function
   public static void main(String args[])
   {
      int val[] = new int[]{60, 100, 120};
      int wt[] = new int[]{10, 20, 30};
      int  W = 50;
      int n = val.length;
      System.out.println(knapSack(W, wt, val, n));
   }*/
}