/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_4;

import java.util.ArrayList;

/**
 *
 * @author krish
 */
public class EularTour {

    static void dfs1(ArrayList<ArrayList<Integer>> adj, int cur, int par) {
        System.out.print(cur + " ");
        for (int nbr : adj.get(cur)) {
            if (nbr != par) {
                dfs1(adj, nbr, cur);
            }
        }
        System.out.print(cur + " ");
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = 3;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 3);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 2, 4);
//        addEdge(adj, 3, 4);
        //printGraph(adj);
        dfs1(adj, 2, 1);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
