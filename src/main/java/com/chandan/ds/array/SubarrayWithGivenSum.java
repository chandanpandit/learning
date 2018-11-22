package com.chandan.ds.array;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int S = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            solve(a, n, S);
        }
    }

    private static void solve(int[] a, int n, int s) {
        int x = -1, y = -1;
        int i = 0, j = 1, sum = a[0];
        while (i < n && j < n) {
            if (sum == s) {
                x = i + 1;
                y = j;
                break;
            } else if (sum > s) {
                sum -= a[i];
                i++;
            } else {
                sum += a[j];
                j++;
            }
        }
        if (x == -1) {
            System.out.println(-1);
        } else {
            System.out.println(x + " " + y);
        }
    }
}
