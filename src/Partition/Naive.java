/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partition;

/**
 *
 * @author krish
 */
public class Naive {

    public static void main(String[] args) {
        partition(new int[]{5, 13, 6, 9, 12, 11, 8}, 0, 6, 6);
    }

    static void partition(int arr[], int l, int h, int p) {
        int temp[] = new int[h - l + 1];
        int index = 0;
        for (int i = l; i <= h; i++) {
            if (arr[i] <= arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = l; i <= h; i++) {
            if (arr[i] > arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = l; i <= h; i++) {
            arr[i] = temp[i - l];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
