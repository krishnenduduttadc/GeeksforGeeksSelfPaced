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
public class DFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s]=true;
        System.out.print(s+" ");
        for (int i : adj.get(s)) {
            if(visited[i]==false){
                DFSRec(adj,i,visited);
            }
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        boolean visited[] = new boolean[v];
        DFSRec(adj, s, visited);
    }

    public static void main(String a[]) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);

        printGraph(adj);
        System.out.println("*************************************");
        DFS(adj, V, 0);
    }

}
