/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author krish
 */
public class Snake {

    static int R = 4, C = 4;

    static void printSnake(int mat[][]) {

        for(int i=0;i<R;i++){
            if(i%2==0){
                for(int j=0;j<C;j++){
                    System.out.print(" "+mat[i][j]);
                }
            }else{
                for(int j=C-1;j>=0;j--){
                    System.out.print(" "+mat[i][j]);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

        printSnake(arr);
    }
}
