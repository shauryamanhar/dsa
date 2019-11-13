package dsa.shaurya.graph;

import java.util.Scanner;
import java.util.Stack;

import javafx.scene.transform.Scale;

public class Dfs {

	public static void main(String[] args) {
		int graph[][] = new int[5][5];
		addEdge(graph,0, 1); 
	    addEdge(graph,0, 2); 
	    addEdge(graph,1, 2); 
	    addEdge(graph,2, 0); 
	    addEdge(graph,2, 3); 
	    addEdge(graph,3, 3); 
	  
//	    2
//	    0
//	    1
//	    3
	    
		int vertex = graph.length;
		int visited[] = new int[vertex];
		dfs(graph,2,visited,vertex);
		System.out.println("++++++++");
		visited = new int[vertex];
		dfsWithStack(graph,2,visited,vertex);
		
	}
	
	static void addEdge(int graph[][],int x,int y) {
		graph[x][y]=1;
		graph[y][x]=1;
	}
	static void dfs(int graph[][],int source,int visited[],int vertex) {
		visited[source]=1;
		System.out.println(source);
		for(int v=0;v<vertex;v++) {
			if(visited[v]!=1 && graph[source][v]==1) {
				dfs(graph,v,visited,vertex);
			}
		}
		
	}
	static void dfsWithStack(int graph[][],int source,int visited[],int vertex) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		int temp;
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if (visited[temp]!=1) { 
	            System.out.println(temp+""); 
	            visited[temp] = 1; 
	        } 
			for(int v=0;v<vertex;v++) {
				if(visited[v]!=1 && graph[temp][v]==1) {
					stack.push(v);
				}
			}
		}
	}//dfs with stack
	
	static void print(int a[][]) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
