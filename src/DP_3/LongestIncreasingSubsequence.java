/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP_3;

/**
 *
 * @author krish
 */
public class LongestIncreasingSubsequence {

    static int LIS(int arr[], int n) {
        int lis[] = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int res = lis[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(lis[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 8, 10, 5, 1};
        int n = 7;

        System.out.println(LIS(arr, n));

    }
}
