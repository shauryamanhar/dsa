package dsa.shaurya.graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class TheFlight{
	static int mat[][];
	static boolean vis[];
	static int parent[];
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("D:\\Git\\dsa\\src\\testcase.txt"));
		int n,m,t,c;
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();//All the airports will switch their states from Loading to Running and vice versa after every T minutes. 
		c = sc.nextInt();//The time taken to travel through any flight route is C minutes.
		
		mat = new int[n][n];
		vis = new boolean[n];
		parent = new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=-1;
		}
		ans = new ArrayList<Integer>();
		int x,y;
		for(int i=0;i<m;i++) {
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			mat[x][y]=1;
			mat[y][x]=1;
		}
		
		x = sc.nextInt()-1;
		y = sc.nextInt()-1;
		bfs(x,y,n);
	}
	
	
	static void bfs(int src,int dest,int n) {
		Queue< Integer> q = new LinkedList<Integer>();
		int distance[] = new int[n];
		int path[] = new int[n];
		for(int i=0;i<n;i++) {
			distance[i]=-1;
			path[i]=-1;
		}
		
		q.add(src);
		distance[src]=0;
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			for(int i=0;i<n;i++) {
				if(mat[vertex][i]==1 && distance[i]==-1) {
					distance[i]=distance[vertex]+1;
					path[i]=vertex;
					if(i==dest) {
						break;
					}
					q.add(i);
				}
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(dest);
		int s = dest;
		while(s!=src){
			s = path[s];
			ans.add(s);
		}
		System.out.println(ans.size());
		for(int i=ans.size()-1;i>=0;i--) {
			System.out.print(ans.get(i)+1+" ");
		}
		System.out.println();
		
	}
}