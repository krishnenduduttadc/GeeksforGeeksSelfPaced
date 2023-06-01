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
public class MinimumJumpstoreachEnd {

    static int minJumps(int arr[], int n) {

        int dp[] = new int[n];
        int i, j;

        dp[0] = 0;

        for (i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 2, 1}, n = 6;

        System.out.println(minJumps(arr, n));

    }
}
