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
public class CoinChange {

    static int getCount(int coins[], int n, int sum) {
        int dp[][] = new int[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (coins[j - 1] <= i) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }

        }return dp[sum][n];
    }

    public static void main(String a[]) {
        int coins[] = {1, 2, 3}, sum = 4, n = 3;

        System.out.println(getCount(coins, n, sum));
    }
}
