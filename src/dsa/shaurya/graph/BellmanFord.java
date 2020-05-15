package dsa.shaurya.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BellmanFord {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n ,e;
		n = scan.nextInt();
		e = scan.nextInt();
		ArrayList<Integer> adj[] = new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		int wt[][] = new int[n][n];
		int u,v,w;
		for(int i=0;i<e;i++) {
			u = scan.nextInt()-1;
			v = scan.nextInt()-1;
			w = scan.nextInt();
			adj[u].add(v);
			wt[u][v]=w;
		}
		bellmanFord(adj, wt, 0);
	}
	static final int MAX = Integer.MAX_VALUE;
	static void bellmanFord(ArrayList<Integer>[]adj,int wt[][],int src) {
		int V = adj.length;
		int distance[] = new int[V];
		int parent[] = new int[V];
		//set distance of every vertex to be infinity initially
		for(int i=0;i<V;i++) {
			distance[i]=MAX;
		}
		distance[src]=0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		int v,newDistance;
		for(int i=0;i<V-1;i++) {
			while(!q.isEmpty()) {
				v = q.poll();
				for(int w:adj[v]) {
					newDistance = distance[v]+wt[v][w];
					if(distance[w]>newDistance) {
						distance[w]=distance[v]+wt[v][w];
						parent[w]=v;
						q.add(w);
					}
				}
			}
		}//for
		for(int i=0;i<V;i++) {
			System.out.println((i+1)+"->"+distance[i]);
		}
	}
}

/*

case 1:
7 10
1 2 6
1 3 5
1 4 5
2 5 -1
3 2 -2
3 5 1
4 3 -2
4 6 -1
5 7 3
6 7 3
1->0
2->1
3->3
4->5
5->0
6->4
7->3

case 2:
4 4
1 2 4
1 4 5
3 2 -10
4 3 3
1->0
2->-2
3->8
4->5


*/