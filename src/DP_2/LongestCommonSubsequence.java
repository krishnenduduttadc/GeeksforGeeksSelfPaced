/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP_2;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class LongestCommonSubsequence {

    static int[][] memo;

    static int lcs(String s1, String s2, int n, int m) {

        if (memo[n][m] != -1) {
            return memo[n][m];
        }
        if (n == 0 || m == 0) {
            memo[n][m] = 0;
        } else {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                memo[n][m] = 1 + lcs(s1, s2, n - 1, m - 1);

            } else {
                memo[n][m] = Math.max(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m));
            }
        }

        return memo[n][m];
    }

    public static void main(String[] args) {
        String s1 = "AXYZ", s2 = "BAZ";
        //String s1 = "aaabbcc", s2 = "abbc";
        int n = 4, m = 3;
        memo = new int[n + 1][m + 1];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        System.out.println(lcs(s1, s2, n, m));
    }
}
