/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_2;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class Prim {

    static final int V = 4;

    public static int primMST(int graph[][]) {
        int[] key = new int[V];
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        boolean[] mSet = new boolean[V];
        for (int count = 0; count < V; count++) {
            int u = -1;

            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mSet[u] = true;
            res += key[u];

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mSet[v] == false) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
            {0, 5, 8, 0},
            {5, 0, 10, 15},
            {8, 10, 0, 20},
            {0, 15, 20, 0},};

        System.out.print(primMST(graph));
    }
}