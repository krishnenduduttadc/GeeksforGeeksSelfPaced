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
public class BFSDetectCycleDirected {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 4, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        topologicalSort(adj, V);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] ind = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                ind[j] = ind[j] + 1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        int c = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i : adj.get(u)) {
                ind[i] = ind[i] - 1;
                if (ind[i] == 0) {
                    q.add(i);
                }
                c++;
            }
        }

        if (c != V) {
            System.out.println("Cycle exist");
        } else {
            System.out.println("Cycle does not exist");
        }
    }
}
