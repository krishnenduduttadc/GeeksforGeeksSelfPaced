/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_2;

import java.util.*;

/**
 *
 * @author krish
 */
public class DetectCycleDirectedGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        boolean[] recSt = new boolean[V];
        for (int i = 0; i < V; i++) {
            recSt[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (DFSRec(adj, i, visited, recSt) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
        visited[s] = true;
        recSt[s] = true;

        for (int u : adj.get(s)) {
            if (visited[u] == false && DFSRec(adj, u, visited, recSt) == true) {
                return true;
            } else if (recSt[u] == true) {
                return true;
            }
        }
        recSt[s] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        if (DFS(adj, V) == true) {
            System.out.println("Cycle found");
        } else {
            System.out.println("No cycle found");
        }
    }
}
