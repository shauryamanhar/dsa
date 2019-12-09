package dsa.shaurya.graph;
import java.util.*;
public class TopologicalSorting {

	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for (int j=0;j<n ;j++) {
				arr[i][j] = scan.nextInt();
			}
		}//for
		boolean visited[] = new boolean[n];
		topologicalByDfs(0,arr,n,visited);
		System.out.println(order);
		int t[] =topological(arr,n);
		System.out.println("topological Sorting is ");
		for(int i:t){
			System.out.print(i+" ");
		}
	}//main

	//global
	static LinkedList<Integer> order = new LinkedList<Integer>();
	static void topologicalByDfs(int currVertex,int arr[][],int n,boolean visited[]){
		visited[currVertex]=true;
		for (int i=0;i<n;i++) {
			if(arr[currVertex][i]==1 && visited[i]==false){
				visited[i]=true;
				topologicalByDfs(i,arr,n,visited);
			}
		}
		order.addFirst(currVertex);
	}//topologicalByDfs




	//using bfs
	static int[] topological(int arr[][],int n){
		int T[] = new int[n];
		boolean visited[] = new boolean[n];
		int inDegree[] = new int[n];

		//calculating in in degree
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==1){
					inDegree[j] = inDegree[j]+1;
				}
			}
		}//for


		java.util.Queue<Integer> q = new LinkedList<Integer>();
		//adding vertex with 0 in degree
		for(int i=0;i<n;i++){
			if(inDegree[i]==0){
				q.add(i);
				visited[i] = true;
			}
		}//for

		int l=0;
		while(!q.isEmpty()){
				int vertex = q.poll();
				T[l++]=vertex;
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(arr[vertex][j]==1 &&  visited[j]==false){
							inDegree[j] = inDegree[j]-1;
							if(inDegree[j]==0){
								q.add(j);
								visited[j]=true;
							}
						}//if
					}
				}
		}//while
		return T;
	}
}//class


/*
4
0 1 1 0
0 0 0 1
0 0 0 1
0 0 0 0



*/
