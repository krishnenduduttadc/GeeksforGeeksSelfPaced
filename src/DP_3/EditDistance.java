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
public class EditDistance {

    static int eD(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1],
                            dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String a[]) {
        String s1 = "cat", s2 = "cut";
        int n = 3, m = 3;

        System.out.println(eD(s1, s2, m, n));
    }
}
