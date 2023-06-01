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
public class CountBST {
    static int countBSTs(int n)
	{
		int dp[] = new int[n+1];

		dp[0] = 1;

		for(int i=1; i<=n; i++)
		{
			dp[i] = 0;

			for(int j=0; j<i; j++)
			{
				dp[i] += dp[j] * dp[i-j-1];
			}
		}

		return dp[n];
	}

	public static void main (String[] args) {
		
		int n = 4;
    
        System.out.println(countBSTs(n));
		

	}
}
