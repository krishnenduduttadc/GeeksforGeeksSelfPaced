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
public class Fibb {

    static int[] memo;

    static int nthfib(int n) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1) {
                return n;
            } else {
                res = nthfib(n - 1) + nthfib(n - 2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 7;

        memo = new int[n + 1];

        Arrays.fill(memo, -1);

        System.out.println(nthfib(n));
    }
}
