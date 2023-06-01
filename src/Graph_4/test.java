/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_4;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author krish
 */
public class test {

    public static void main(String[] args) {
        //int arr[] = {1,2,5};
        //int n = arr.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(4);

        int N = arr.size();
        int p = 0;
        for (int i = N - 1, j = 0; i >= 0 && j < N; i--, j++) {
            p += arr.get(j) * (int) Math.pow(10, i);
        }
        p = p + 1;
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for (int i = 0; i < N+1; i++) {
            int rem = p % 10;
            arr2.add(rem);
            p = p / 10;
        }
        Collections.reverse(arr2);

        for (Integer i : arr2) {
            System.out.print(i);
        }
    }
}
