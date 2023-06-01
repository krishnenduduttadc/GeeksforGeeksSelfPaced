/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class Bibartite {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] visited = new int[v];
        int color = 1;
        boolean ans = dfs2(adj, 0, visited, -1, color);
        for (int i = 0; i < v; i++) {
            System.out.println(i + " - Color " + visited[i]);
        }

        return ans;
    }

    static boolean dfs2(ArrayList<ArrayList<Integer>> adj, int s, int[] visited, int parent, int color) {
        visited[s] = color;
        for (int nbr : adj.get(s)) {
            if (visited[nbr] == 0) {
                boolean sub = dfs2(adj, nbr, visited, s, 3 - color);
                if (sub == false) {
                    return false;
                }
            } else if (nbr != parent && color == visited[nbr]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);

        if (dfs(adj, V)) {
            System.out.println("Yes its bipartite");
        } else {
            System.out.println("Not bipartite");
        }
    }
}
