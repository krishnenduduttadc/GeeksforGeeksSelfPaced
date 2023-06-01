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
public class Insertion {
    public static void main(String[] args) {
        insertion(new int[]{6, 8, 4, 8, 8});
    }

    private static void insertion(int[] arr) {
            int n=arr.length;
            for(int i=1;i<n;i++){
                int key=arr[i];
                int j=i-1;
                while(j>=0 && arr[j]>key){
                    arr[j+1]=arr[j];
                    j--;
                }
                arr[j+1]=key;
            }
            
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            
    }

}
