package com.chandan.ds.array;

public class PeakFinder {
    public static void main(String[] args) {
        //int[] a = {1, 2, 3, 4};
        //int[] a = {4, 3, 2, 1};
        //int[] a = {4, 4, 4, 4};
        //int[] a = {5, 10, 20, 15};
        //int[] a = {10, 20, 15, 2, 23, 90, 67};
        //int[] a = {1,1,1,1,1,5};
        //int[] a = {1, 3, 20, 4, 1, 0};
        int[] a = {1, 2, 3, 4, 5, 9};
        System.out.println("Peak => " + findPeak(a));

        System.out.println("****************** Peak in 2D array*********************");
        int[][] b = {
                {5, 2, 1, 7},
                {8, 2, 9, 1},
                {2, 1, 9, 3},
                {1, 2, 1, 5},
                {1, 2, 3, 5}
        };
        System.out.println(findPeak(b));
        int[][] c = {
                {10, 8, 10, 10},
                {14, 13, 12, 11},
                {15, 9, 11, 21},
                {16, 17, 19, 20}
        };
        System.out.println(findPeak(c));
    }

    // finds a peak in a 1D array
    static int findPeak(int[] a) {
        int n = a.length;
        if (n == 0)
            throw new RuntimeException("Invalid Inputs");
        else if (n == 1)
            return a[0];
        else
            return findPeak(a, 0, n - 1, n);
    }

    private static int findPeak(int[] a, int l, int h, int n) {
        int mid = l + (h - l) / 2;
        if (mid > 0 && a[mid] < a[mid - 1])
            return findPeak(a, l, mid - 1, n);
        else if (mid < n - 1 && a[mid] < a[mid + 1])
            return findPeak(a, mid + 1, h, n);
        else
            return a[mid];
    }

    public static int findPeak(int[][] a) {
        if (a.length == 0 || a[0].length == 0)
            throw new RuntimeException("Invalid inputs");
        return findPeak(a, 0, a[0].length - 1);
    }

    private static int findPeak(int[][] a, int l, int h) {
        int m = (l + h) / 2;
        int i = findMaxIndex(a, m);
        if (m > 0 && a[i][m - 1] > a[i][m]) { //  search in left
            return findPeak(a, l, m - 1);
        } else if (m < a[0].length - 1 && a[i][m + 1] > a[i][m]) {
            return findPeak(a, m + 1, h);
        } else {
            return a[i][m];
        }
    }

    private static int findMaxIndex(int[][] a, int m) {
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][m] > a[maxIndex][m]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
