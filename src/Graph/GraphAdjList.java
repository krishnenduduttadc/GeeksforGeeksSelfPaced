/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class GraphAdjList {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj,int s){
        Queue<Integer> q=new LinkedList<Integer>();
        Boolean visited[]=new Boolean[adj.size()];
        Arrays.fill(visited, Boolean.FALSE);
        visited[s]=true;
        q.add(s);
        System.out.print("BFS ");
        while(q.isEmpty()==false){
            int u=q.poll();
            System.out.print(u+" ");
            for(int i:adj.get(u)){
                if(visited[i]==false){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
    static void BFSDis(ArrayList<ArrayList<Integer>> adj,int s){
        boolean visited[]=new boolean[adj.size()+1];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false){
                BFS(adj,i);
            }
        }
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj,int V){
        boolean visited[]=new boolean[V];
        System.out.print("\nDFS ");
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                DFSRec(adj,i,visited);
            }
        }
    }
    static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited){
        visited[s]=true;
        System.out.print(s+ " ");
        for(int u:adj.get(s)){
            if(visited[u]==false){
                DFSRec(adj,u,visited);
            }
        }
    }
    
    public static void main(String a[]) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Adding edges one by one 
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        printGraph(adj); 
        
        BFS(adj,0);
        //BFSDis(adj,0);
        
        DFS(adj,V);
    }
}
