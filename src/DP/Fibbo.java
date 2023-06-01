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
public class Fibbo {

    static int memo[];

    static int fib(int n) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1) {
                res = n;
            } else {
                res = fib(n - 1) + fib(n - 2);
            }
            memo[n] = res;
        }
        return memo[n];

    }

    public static void main(String a[]) {
        int n=15;
        memo=new int[n+1];
        for(int i=0;i<=n;i++){
            memo[i]=-1;
        }
        System.out.println("The nth fibbonacchi no is: " + fib(n));
    }

}
