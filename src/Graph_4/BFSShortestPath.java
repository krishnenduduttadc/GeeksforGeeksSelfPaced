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
public class BFSShortestPath {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj, int s, int v) {
        boolean[] visited = new boolean[v];
        int[] dist = new int[v];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        dist[s] = 0;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");
            for (int i : adj.get(front)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                    dist[i] = dist[front] + 1;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println("shortest distance to " + i + " is " + dist[i] + "");
        }

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
        printGraph(adj);
        BFS(adj, 0, V);
    }
}
