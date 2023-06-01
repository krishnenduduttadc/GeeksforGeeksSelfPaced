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
public class Boundary {

    static int R = 4, C = 4;

    static void bTraversal(int mat[][]) {
        if (R == 1) {
            for (int i = 0; i < C; i++) {
                System.out.print(mat[0][i] + " ");
            }
        } else if (C == 1) {
            for (int i = 0; i < R; i++) {
                System.out.print(mat[i][0] + " ");
            }
        } else {
            for (int i = 0; i < C; i++) {
                System.out.print(mat[0][i] + " ");
            }
            for (int i = 1; i < R; i++) {
                System.out.print(mat[i][C - 1] + " ");
            }
            for (int i = C - 2; i >= 0; i--) {
                System.out.print(mat[R - 1][i] + " ");
            }
            for (int i = R - 2; i >= 1; i--) {
                System.out.print(mat[i][0] + " ");
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

        bTraversal(arr);
    }
}
