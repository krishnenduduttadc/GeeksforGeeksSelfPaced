/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author krish
 */
public class Longestsubarrayequal0and1 {
    public static void main (String[] args) {
        int arr[] = new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1};
        int len = arr.length;
        
        System.out.println(largestZeroSubarray(arr, len));
    }
    
    static int largestZeroSubarray(int arr[], int n)
    {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0, maxLen = 0;
        for(int i = 0; i < n; i++)
         arr[i] = (arr[i] == 0) ? -1 : 1;
         
        for(int i = 0; i < n; i++)
        {
            sum += arr[i];
            if (sum == 0)
             maxLen = i+1;
             
            if(hm.containsKey(sum + n) == true)
            {
                if(maxLen < i - hm.get(sum + n))
                 maxLen = i - hm.get(sum + n);
                
            }else hm.put(sum + n, i);
        }
        return maxLen;
    }
}
