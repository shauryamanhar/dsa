package dsa.shaurya.graph;

import java.util.*;

public class Bfs {
	static ArrayList<Integer> adj[] = null;
	static boolean visited[] = null;
	static int level[] = null;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int n = scan.nextInt();
		int e = scan.nextInt();
		adj = new ArrayList[n];
		visited = new boolean[n];
		level = new int[n];
		for(int i=0;i<n;i++) {
			adj[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			adj[x-1].add(y-1);
			adj[y-1].add(x-1);
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				bfs(i);
			}
		}
		System.out.println("level "+level[2]);
	}//main
	
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s]=true;
		level[s]=0;
		while(!q.isEmpty()) {
			int p = q.poll();
			System.out.println("p "+(p+1)+" level "+level[p]);
			for(int temp:adj[p]) {
				if(visited[temp]==false) {
					q.add(temp);
					visited[temp]=true;
					level[temp]=level[p]+1;
				}
			}
		}//while
	}

}
