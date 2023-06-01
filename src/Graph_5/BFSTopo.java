/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_5;

import java.util.*;

/**
 *
 * @author krish
 */
public class BFSTopo {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] indeg = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indeg[j] = indeg[j] + 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + "->");
            for (int i : adj.get(u)) {
                indeg[i] = indeg[i] - 1;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 1);

        //System.out.println("Following is a Topological Sort of");
        topologicalSort(adj, V);
    }
}
