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
public class DFSBackEdgeUndirected {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean contains_cycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        return dfs(adj, visited, 0, -1);
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {
        visited[s] = true;
        for (int nbr : adj.get(s)) {
            if (visited[nbr] == false) {
                visited[nbr] = true;
                boolean res = dfs(adj, visited, nbr, s);
                if (res) {
                    return true;
                }
            } else if (nbr != parent) {
                //backedge
                System.out.println(s + "---->" + nbr);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);

        contains_cycle(adj, V);

    }
}
