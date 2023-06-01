/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP_2;

import java.util.Scanner;

/**
 *
 * @author krish
 */
public class MinCoinsValue {

    static int minCoins(int arr[], int m, int value) {
        int dp[] = new int[value + 1];

        dp[0] = 0;
        for (int i = 1; i <= value; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= value; i++) {

            for (int j = 0; j < m; j++) {
                if (arr[j] <= i) {
                    int sub_res = dp[i - arr[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }

                }
            }

        }
        return dp[value];
    }

    static int minCoinsRec(int coins[], int n, int value) {
        if (value == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= value) {
                int sub_res = minCoins(coins, n, value - coins[i]);
                if (sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 1}, val = 5, n = 3;

        //System.out.println(minCoins(arr, n, val));
        System.out.println(minCoinsRec(arr, n, val));

    }
}
