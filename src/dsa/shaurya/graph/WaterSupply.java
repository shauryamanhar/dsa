package dsa.shaurya.graph;

import java.io.File;
import java.util.*;

public class WaterSupply {
    static ArrayList<Integer> adj[];
    static boolean blocked[];
    static boolean vis[];
    static int maxSize=-1,size;
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(new File("C:\\Users\\shaur\\Downloads\\case.txt"));
        int n = sc.nextInt();
        adj = new ArrayList[n];
        vis = new boolean[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<Integer>();
        }
        int u,v;
        for(int i=0;i<n-1;i++){
            u=sc.nextInt()-1;
            v=sc.nextInt()-1;
            adj[u].add(v);
//            adj[v].add(u);
        }
        blocked = new boolean[n];
        for(int i=0;i<n;i++){
            if(sc.nextInt()==1){
                blocked[i]=true;
            }
        }
        for(int i=0;i<n;i++){
        	size=1;
            if(!vis[i] && blocked[i]){
                dfs(i);
                if(size>maxSize){
                    maxSize=size;
                }
                size=0;
            }
        }
        System.out.println(maxSize==-1?0:maxSize);

    }//main

    static void dfs(int src){
//    	System.out.println("vis "+ (src+1));
        vis[src]=true;
        size++;
        for(int v:adj[src]){
            if(!vis[v] && !blocked[v]){
                dfs(v);
            }
        }
    }
}
