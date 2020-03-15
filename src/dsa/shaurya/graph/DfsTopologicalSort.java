package dsa.shaurya.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DfsTopologicalSort {

	public static void main(String[] args) {
		int v;
		int e;
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		Graph g = new Graph(v);
		int a,b;
		for(int i=0;i<v;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			g.add(a,b);
		}
		topologicalSort(g);
	}
	
	static class Graph{
		int vertex;
		ArrayList<Integer> adj[];
		Graph(int vertex){
			this.vertex=vertex;
			adj = new ArrayList[vertex];
			for(int i=0;i<vertex;i++) {
				adj[i]=new ArrayList<Integer>();
			}
		}
		
		void add(int a,int b) {
			adj[a].add(b);
		}
	}//graph

	static void topologicalSort(Graph g) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[g.vertex];
		for(int i=0;i<g.vertex;i++) {
			if(visited[i]==false) {
				topogicalUtil(i,visited,g,stack);
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}

	private static void topogicalUtil(int v, boolean[]visited,Graph g, Stack<Integer> stack) {
		visited[v]=true;
		Integer i;
		for(int w:g.adj[v]) {
			if(visited[w]==false) {
				topogicalUtil(w, visited, g, stack);
			}
		}
		stack.push(v);
	}
	
}

/*

6
6
5 0
5 2
4 0
4 1
2 3
3 1


5 4 2 3 1 0 
*/