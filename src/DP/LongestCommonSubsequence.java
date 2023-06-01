/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class LongestCommonSubsequence {

    static int memo[][];

    static int lcs(String s1, String s2, int m, int n) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        } else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
            } else {
                memo[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
            }
        }

        return memo[m][n];
    }

    public static void main(String a[]) {
        int m = 4, n = 3;
        memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        } 
        System.out.println("LCS is: " + lcs("AXYZ", "BAZ", 4, 3));
    }
}
