/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author krish
 */
public class FibDP {

    static long fib(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + " th fibo no is: " + fib(i));
//        }
        System.out.println(1000 + " th fibo no is: " + fib(50));
    }
}
