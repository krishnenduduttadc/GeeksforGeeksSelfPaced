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
public class DetectCycleUndirectedGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" " + adj.get(i).get(j));
            }
            System.out.println("");
        }
    }

    static boolean contains_cycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        return dfs(adj, visited, 0, -1);
    }

    static private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {
        visited[s]=true;
        System.out.println(s+" ");
        for(int i:adj.get(s)){
            if(visited[i]==false){
                visited[i]=true;
                boolean res=dfs(adj,visited,i,s);
                if(res){
                    return true;
                }
            }else if(i!=parent){
                return true;
            }
        }
        return false;
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
        System.out.println(contains_cycle(adj, V));
    }

}
