package dsa.shaurya.graph;
import java.util.*;
public class MonkIsland {

	static ArrayList<Integer> adj[]; 
	static boolean visited[];
	static int level[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			adj = new ArrayList[n];
			visited  = new boolean[n];
			level = new int[n];
			for(int i=0;i<n;i++) {
				adj[i] = new ArrayList<Integer>();
			}
			int x,y;
			for (int i = 0; i < m; i++) {
				x = scan.nextInt();
				y = scan.nextInt();
				adj[x-1].add(y-1);
				adj[y-1].add(x-1);
			}
			System.out.println(bsp(0,n));
		}//while
	}
	
	static int bsp(int s,int n) {
		int count = 0 ;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		visited[s] =true;
		level[s]=0;
		while(!q.isEmpty()) {
			count++;
			int p = q.poll();
			for(int i:adj[p]) {
				if(visited[i]==false) {
					q.add(i);
					visited[i]=true;
					level[i] = level[p]+1;
				}
			}
		}//while
		return level[n-1];
	}//bsp

}
