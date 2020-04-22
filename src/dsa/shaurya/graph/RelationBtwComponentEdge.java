package dsa.shaurya.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class RelationBtwComponentEdge {
	static ArrayList<Integer> adj[] = null;
	static boolean vis[] = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        adj = new ArrayList[n];
        vis = new boolean[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<Integer>();
        }
        int u,v;
        for(int i=0;i<m;i++){
            u = sc.nextInt()-1;
            v = sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        int component=0;
        
        for(int i=0;i<n;i++) {
        	if(!vis[i]) {
        		component++;
        		dfs(i);
        	}
        }
        int ans = m-(n-k);
        if(component>k) {
        	System.out.println("-1");
        }else {
        	System.out.println(ans);
        }
        
	}
	
	static void dfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		vis[s]=true;
		q.add(s);
		while(!q.isEmpty()) {
			s = q.poll();
			for(int w:adj[s]) {
				if(!vis[w]) {
					vis[w]=true;
					q.add(w);
				}
			}
		}
	}//dfs
	
}
