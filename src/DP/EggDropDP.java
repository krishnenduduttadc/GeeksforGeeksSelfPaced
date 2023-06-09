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
public class EggDropDP {
    	static int res(int n, int f) 
        { 
           
            int dp[][]= new int[n + 1][f + 1]; 
            int res = -1; 
           
          
           
            for (int i = 1; i <= n; i++) { 
                dp[i][1] = 1; 
                dp[i][0] = 0; 
            } 
          
           
            for (int j = 1; j <= f; j++) 
                dp[1][j] = j; 
          
            
            for (int i = 2; i <= n; i++) { 
                for (int j = 2; j <= f; j++) { 
                    dp[i][j] = Integer.MAX_VALUE; 
                    for (int x = 1; x <= j; x++) { 
                        res = 1 + Math.max( 
                                      dp[i - 1][x - 1], 
                                      dp[i][j - x]); 
                        if (res < dp[i][j]) 
                            dp[i][j] = res; 
                    } 
                } 
            } 
          
            
            return dp[n][f]; 
        }

	public static void main (String[] args) {
		
			int n = 2;

		    int f = 10;

		
        System.out.println(res(n, f));
		

	}
}
