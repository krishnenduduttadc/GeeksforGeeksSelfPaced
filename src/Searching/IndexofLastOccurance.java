/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searching;

/**
 *
 * @author krish
 */
public class IndexofLastOccurance {
    public static void main(String[] args) {
        System.out.println(binsearchlast(new int[]{3, 5, 7, 8, 9, 11, 11, 11}, 0, 7, 11));
    }

    private static int binsearchlast(int[] arr, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            return binsearchlast(arr, low, mid - 1, x);
        } else if (arr[mid] < x) {
            return binsearchlast(arr, mid + 1, high, x);
        } else {
            if (mid == arr.length-1 || arr[mid] != arr[mid+1] ) {
                return mid;
            } else {
                return binsearchlast(arr, mid+1, high, x);
            }
        }
    }
}
