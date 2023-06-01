/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_striver;

import java.util.*;

/**
 *
 * @author krish
 */
public class BipartiteDFS {

    private boolean dfs(int node, int col, int color[],
            ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;
        for (int n : adj.get(node)) {
            if (color[n] == -1) {
                if (dfs(n, 1 - col, color, adj) == false) {
                    return false;
                }
            } else if (color[n] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList<ArrayList< Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        BipartiteDFS obj = new BipartiteDFS();
        boolean ans = obj.isBipartite(4, adj);
        if (ans) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
