import java.util.*;
public class TopologicalSorting {

	public static void main(String[] args) {
		int n = 4;
		int arr[][] = new int[n][n];
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<n;i++){
			for (int j=0;j<n ;j++) {
				arr[i][j] = scan.nextInt();
			}
		}//for
		int t[] =topologicalSorting(arr,n);
		System.out.println("topological Sorting is ");
		for(int i:t){
			System.out.print(i+" ");
		}
	}//main

	static int[] topologicalSorting(int arr[][],int n){
		int T[] = new int[n];
		boolean visited[] = new boolean[n];
		int inDegree[] = new int[n];
		java.util.Queue<Integer> q = new LinkedList<Integer>();

		//calculating inDegree of vertex
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==1){
					inDegree[j]=inDegree[j]+1;
				}
			}//for
		}//for

		for(int i=0;i<n;i++){
			if(inDegree[i]==0){
				q.add(i);
				visited[i]=true;
			}
		}//for
		int i=0;
		while(!q.isEmpty()){
			int vertex = q.poll();
			T[i++] = vertex;
			for(int j=0;j<n;j++){
				if(arr[vertex][j]==1 && visited[j]==false){
					inDegree[j] = inDegree[j]-1;
					if(inDegree[j]==0){
						q.add(j);
						visited[j]=true;
					}
				}//if
			}//for
		}//while
		return T;
	}//topologicalSorting

}//class


/*

0 1 1 0
0 0 0 1
0 0 0 1
0 0 0 0



*/
