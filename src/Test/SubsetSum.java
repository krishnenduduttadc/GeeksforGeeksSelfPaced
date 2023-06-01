/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Vector;

/**
 *
 * @author krish
 */
public class SubsetSum {

    

    static void Subsets(int arr[], int n, int sum) {
        Vector<Integer> v = new Vector<Integer>();
        Subsets(arr, n, v, sum);
    }

    static void Subsets(int arr[], int n, Vector<Integer> v,int sum) {

        if (sum == 0) {
            for (int i = 0; i < v.size(); i++) 
                System.out.print(v.get(i) + " ");           
            System.out.println();
            return;
        }

        if (n == 0) {
            return;

        }

        Subsets(arr, n - 1, v, sum);
        Vector<Integer> v1 = new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        Subsets(arr, n - 1, v1, sum - arr[n - 1]); 

    }
    
    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int sum = 6;
        int n = arr.length;
        Subsets(arr, arr.length, sum);
    }
}
