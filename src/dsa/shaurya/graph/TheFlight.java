package dsa.shaurya.graph;
import java.util.*;

public class TheFlight {
	static int n,c,t;
	static ArrayList<Integer>[] adj ;
	static ArrayList<Integer> ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		adj = new ArrayList[n];
		ans = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		int m = scan.nextInt();
		t = scan.nextInt();
		c = scan.nextInt();
		
		for(int i=0;i<m;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			adj[x-1].add(y-1);
			adj[y-1].add(x-1);
		}//for
		
		int src = scan.nextInt();
		int dst = scan.nextInt();
		
		for(int i=0;i<n;i++) {
			Collections.sort(adj[i]);
		}
		int parent[] = new int[n];
		bfs(src-1,dst-1,parent);
//		for(int i:parent) {
//			System.out.println(i);
//		}
		System.out.println(ans);
	}//main
	
	
	static void bfs(int src,int dst,int parent[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[n];
		parent[src]=-1;
		q.add(src);
		visited[src] = true;
		ans.add(src);
		while(!q.isEmpty()) {
			int vertex = q.poll();
			System.out.println("vertex "+vertex);
			for(int v :adj[vertex]) {
				if(!visited[v]) {
					visited[v]=true;
					parent[v]=vertex;
					if(v==dst) {
						ans.add(v);
						System.out.println("v "+v+" vertex "+vertex);
						return;
					}
					ans.add(v);
					q.add(v);
				}
			}
		}//while
		
		
	}//bfs

}
