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
        System.out.println("Peak => "+findPeak(a));
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
}
