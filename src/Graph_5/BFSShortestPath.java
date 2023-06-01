/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class BFSShortestPath {

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 4);

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        BFSShortest(adj, V, 0, dist);

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);

        }
    }

    private static void BFSShortest(ArrayList<ArrayList<Integer>> adj, int V, int s, int[] dist) {

        boolean[] visited = new boolean[V];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int i : adj.get(u)) {
                if (visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                    dist[i] = dist[u] + 1;
                }
            }
        }
    }
}
