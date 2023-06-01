/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class TopologicalDFS {
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, ArrayList<Integer> ordering) {
        visited[node] = true;
        for (int p : adj.get(node)) {
            if (visited[p] == false) {
                dfs(adj, p, visited, ordering);
            }
        }
        ordering.add(node);
    }
    
    static void dfs_topological_sort(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ordering = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, ordering);
            }
        }
        Collections.reverse(ordering);
        for (int node : ordering) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 0, 2);
        
        addEdge(adj, 1, 3);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 3);
        
        dfs_topological_sort(adj, V);
    }
}
