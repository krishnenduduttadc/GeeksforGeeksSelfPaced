/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author krish
 */
public class IntersectionSorted {

    public static void main(String[] args) {
        interNaive(new int[]{3, 5, 7, 10}, new int[]{5, 5, 7, 10});
    }

    private static void interNaive(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (i>0 && (a[i - 1] == a[i]) ) {
                continue;
            }
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    System.out.print(a[i]+" ");
                }

            }

        }
    }

}
