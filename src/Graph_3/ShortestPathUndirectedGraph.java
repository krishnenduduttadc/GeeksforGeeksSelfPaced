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
public class ShortestPathUndirectedGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s, int[] dist) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int i: adj.get(u)){
                if(visited[i]==false){
                    dist[i]=dist[u]+1;
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        BFS(adj, V, 0, dist);

        System.out.println("\n******************");
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

    }
}
