/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author krish
 */
public class MaxSumwithno2consecutive {

    static int maxSum(int arr[], int n) {
        if (n == 0) {
            return arr[0];
        }

        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;

        for (int i = 3; i <= n; i++) {
            res = Math.max(prev, prev_prev + arr[i - 1]);

            prev_prev = prev;

            prev = res;
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 5, arr[] = {10, 20, 30, 40, 50};

        System.out.println(maxSum(arr, n));

    }
}
