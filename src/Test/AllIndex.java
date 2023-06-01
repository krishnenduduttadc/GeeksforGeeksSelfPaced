/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author krish
 */
public class AllIndex {

    public static void main(String[] args) {
        int input[] = {9, 8, 10, 8, 8};
        
        int p[]=allIndexes(input, 8);
        for (int i = 0; i < p.length; i++) {
            System.out.print(" "+p[i]);
            
        }
    }

    public static int[] allIndexes(int input[], int x) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
         */
        return allOcc(input, 0, input.length - 1, x);
    }

    public static int[] allOcc(int arr[], int low, int high, int x) {
        if (low > high) {
            return new int[0];
        }

        int[] smallAns=allOcc(arr, low+1, high, x);
        if(arr[low]==x){
            int ans[]=new int[smallAns.length+1];
            ans[0]=low;
			for(int i=0;i<smallAns.length;i++)
				ans[i+1]=smallAns[i];
			return ans;
        }
        return  smallAns;
    }

}
