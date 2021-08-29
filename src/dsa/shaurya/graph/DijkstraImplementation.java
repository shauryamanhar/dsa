package dsa.shaurya.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraImplementation {

	public static void main(String[] args) {
		
	}
	
	void dijkstra(ArrayList<Node>[]adj,int src) {
		int V = adj.length;
		PriorityQueue<Node> pq = new PriorityQueue<DijkstraImplementation.Node>();
		pq.add(new Node(src,0));
		int v,w;
		int distance[] = new int[V];
		for(int i=0;i<V;i++) {
			distance[i]=-1;
		}
		
		distance[src]=0;
		int distTemp;
		while(!pq.isEmpty()) {
			v=pq.poll().vertex;
			for(Node node:adj[v]) {
				distTemp = distance[v]+node.weight;
				if(distance[node.weight]==-1) {
					distance[node.weight]=distTemp;
					pq.add(new Node(node.weight,distTemp));
				}
				if(distance[node.weight]>distTemp) {
					distance[node.weight]=distTemp;
					
				}
				
			}
		}
	}
	
	class Node implements Comparable<Node>{
		int vertex;
		int weight;
		Node(int vertex,int weight){
			this.vertex=vertex;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node n2) {
			if(weight==n2.weight) {
				return 0;
			}else if(weight<n2.weight) {
				return -1;
			}else {
				return 1;
			}
		}
	}//Node
}
