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
public class BFS {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 4);


        System.out.println("Following is Breadth First Traversal: ");
        BFS(adj, V, 0);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V];
        visited[s]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        
        while(!q.isEmpty()){
            int p=q.poll();
            System.out.print(" "+p);
            for(int i:adj.get(p)){
                if(visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        
    }
}
