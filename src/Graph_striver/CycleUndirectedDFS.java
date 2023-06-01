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
public class CycleUndirectedDFS {

    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;
        for(int n:adj.get(node)){
            if(vis[n]==0){
                if(dfs(n,node,vis,adj)==true){
                    return true;
                }
            }else if(n!=parent){
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[]=new int[V];
        for (int i = 0; i < V; i++) {
            if(dfs(i,-1,visited,adj)==true){
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        CycleUndirectedDFS obj = new CycleUndirectedDFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
