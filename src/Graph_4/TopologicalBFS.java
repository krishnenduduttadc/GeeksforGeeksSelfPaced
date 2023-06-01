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
public class TopologicalBFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" " + adj.get(i).get(j));
            }
            System.out.println("");
        }
    }

    static void topologicalsort(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int p : adj.get(i)) {
                indegree[p] = indegree[p] + 1;
            }
        }
//        for (int i = 0; i < v; i++) {
//            System.out.println(i+" " + indegree[i]);
//        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + "-->");
            for (int p : adj.get(front)) {
                indegree[p] = indegree[p] - 1;
                if (indegree[p] == 0) {
                    q.add(p);
                }
            }
        }

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

        topologicalsort(adj, V);
    }
}
