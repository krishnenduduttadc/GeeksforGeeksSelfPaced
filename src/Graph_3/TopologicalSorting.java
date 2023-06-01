/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_3;

import java.util.*;

/**
 *
 * @author krish
 */
public class TopologicalSorting {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] in_degree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int j:adj.get(i)){
                in_degree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {            
            int u = q.poll();
            System.out.print(" " + u);
            for(int i:adj.get(u)){
                if(--in_degree[i]==0){
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        System.out.println("Following is a Topological Sort of");
        topologicalSort(adj, V);
    }
}
