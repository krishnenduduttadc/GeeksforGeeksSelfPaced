/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP_4;

/**
 *
 * @author krish
 */
public class MinCoinstoMakeValR {

    static int minCoins(int coins[], int n, int val) {

        if (val == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int sub_res = minCoins(coins, n, val - coins[i]);
                if(sub_res!=Integer.MAX_VALUE){
                    res=Math.min(res,sub_res+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 1}, val = 5, n = 3;

        System.out.println(minCoins(arr, n, val));

    }
}
