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
public class MaxCuts {

    static int maxCuts(int n, int a, int b, int c) {

        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;

            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }

            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }

            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }

            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5, a = 1, b = 2, c = 3;

        System.out.println(maxCuts(n, a, b, c));

    }
}
