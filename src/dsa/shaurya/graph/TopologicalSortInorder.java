package dsa.shaurya.graph;

import java.util.*;

public class TopologicalSortInorder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int mat[][] = new int[n][n];
		boolean vis[] = new boolean[n];
		int u,v;
		for(int i=0;i<e;i++) {
			u = s.nextInt()-1;
			v = s.nextInt()-1;
			mat[u][v]=1;
		}
		TopologicalSortInorder t = new TopologicalSortInorder();
		t.topoSort(mat, n, vis);
	}
	
	void topoSort(int mat[][],int n,boolean vis[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		int inorder[] = new int[n];
		inorderCal(mat,n,inorder);
		for(int i=0;i<n;i++) {
			if(inorder[i]==0) {
				q.add(i);
			}
		}
		int counter=0;
		int topologicalSort[] = new int[n];
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			topologicalSort[counter++]=vertex;
			for(int i=0;i<n;i++) {
				if(mat[vertex][i]==1 && !vis[i]) {
					inorder[i]--;
					if(inorder[i]==0) {
						q.add(i);
					}
				}
			}
		}
		
		if(counter!=n) {
			System.out.println("Graph has cycle");
		}else {
			for(int i=0;i<n;i++) {
				System.out.println(topologicalSort[i]+1);
			}
		}
	}//topo
	
	void inorderCal(int mat[][],int n,int inorder[]) {
		for(int col=0;col<n;col++) {
			for(int row=0;row<n;row++) {
				if(mat[row][col]==1) {
					inorder[col]++;
				}
			}
		}
	}//inorder cal
}
/*
5 6
1 2
1 3
2 5
3 5
4 3
4 5


 */
