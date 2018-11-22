package com.chandan.ds.dp;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 10;
        printPascal(n);
        System.out.println("Optimized Version ::");
        printPascalSpaceOptimized(n);
        System.out.println("Recc Version ::");
        printPascalRecc(n);
    }

    /**
     * Time : O(n^2) | Space : O(n^2)
     * @param n
     */
    private static void printPascal(int n) {
        if(n <= 0)
            return;
        int[][] table = new int[n][n];
        table[0][0] = 1;
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                table[i][j] = (j > 0 ? table[i-1][j-1] : 0) + table[i-1][j];
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Time : O(n^2) | Space : O(n)
     * @param n
     */
    private static void printPascalSpaceOptimized(int n) {
        if(n <= 0)
            return;
        int[] table = new int[n];
        table[0] = 1;
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            int v1 = 0;
            // compute the next row and keep preserving required values
            for (int j = 0; j <= i; j++) {
                int sum = v1 + table[j];
                v1 = table[j];
                table[j] = sum;
                System.out.print(table[j]+" ");
            }
            System.out.println();
        }
    }

    private static void printPascalRecc(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                int v = getPascalVal(i,j);
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }

    private static int getPascalVal(int i, int j) {
        // base cases
        if(j < 0 || j > i)
            return 0;
        else if(i == 0)
            return 1;
        else
            return getPascalVal(i-1,j-1) + getPascalVal(i-1,j);
    }
}
