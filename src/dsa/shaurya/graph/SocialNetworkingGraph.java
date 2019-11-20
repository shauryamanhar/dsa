package dsa.shaurya.graph;

import java.util.*;

public class SocialNetworkingGraph {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt();
		int edge = scan.nextInt();
		GraphSocial g = new GraphSocial(node);
		for(int i=0;i<edge;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			g.addEdge(x, y);
		}
		
		int q = scan.nextInt();
		for(int i=0;i<q;i++) {
			int x =scan.nextInt();
			int t =scan.nextInt();
			System.out.println(g.bfs(x-1, t));
		}
	}
}

class GraphSocial {
	private int vertex;
	private LinkedList<Integer> adj[];
	private int distance[];

	public GraphSocial(int v) {
		this.vertex = v;
		adj = new LinkedList[v];
		distance = new int[vertex];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
			distance[i] = 0;
		}
	}// graph

	void addEdge(int s, int d) {
		adj[s].add(d);
		adj[d].add(s);
	}// add edge

	int bfs(int s, int t) {
		boolean visited[] = new boolean[vertex];
		Arrays.fill(distance, 0);
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s]=true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int v:adj[temp]) {
				if(visited[v]==false){
                    visited[v]=true;
                    distance[v]=distance[temp]+1;
                    if(distance[v]==t)
                        count++;
                    q.add(v);
                }
			}
		}//while
		return count;
	}//bfs

}
