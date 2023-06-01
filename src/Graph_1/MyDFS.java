/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_1;

import java.util.ArrayList;

/**
 *
 * @author krish
 */
public class MyDFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s]=true;
        System.out.print(s +" ");
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        } 
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        DFSRec(adj, s, visited);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);

        System.out.println("Following is Depth First Traversal: ");
        DFS(adj, V, 0);
    }
}
