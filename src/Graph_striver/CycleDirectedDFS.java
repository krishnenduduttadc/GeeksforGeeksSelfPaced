/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_striver;

import java.util.*;

/**
 *
 * @author krish
 */
public class CycleDirectedDFS {

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node]=1;
        pathVis[node]=1;
        
        for(int n:adj.get(node)){
            if(vis[n]==0){
                if(dfsCheck(n,adj,vis,pathVis)==true){
                    return true;
                }
            }else if(pathVis[n]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        for(int i=0;i<V;i++){
            if(dfsCheck(i,adj,vis,pathVis)==true){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        CycleDirectedDFS obj = new CycleDirectedDFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
