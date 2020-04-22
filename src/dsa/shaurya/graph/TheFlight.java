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
		Scanner sc = new Scanner(System.in);
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
		for(int i=0;i<n;i++) {
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			mat[x][y]=1;
			mat[y][x]=1;
		}
		
		x = sc.nextInt()-1;
		y = sc.nextInt()-1;
		bfs(x,y);
		ans.add(y);
		int s = parent[y];
		int cnt=1;
		while(s!=x) {
			ans.add(s);
			s = parent[s];
			cnt++;
		}
		ans.add(x);
		System.out.println(ans.size());
		for(int i=ans.size()-1;i>=0;i--)
			System.out.print((ans.get(i)+1)+" ");
		System.out.println();
	}
	
	
	static void bfs(int src,int dest) {
		Queue< Integer> q = new LinkedList<Integer>();
		q.add(src);
		vis[src]=true;
		while(!q.isEmpty()) {
			src = q.poll();
			for(int i=0;i<mat.length;i++) {
				if(mat[src][i]==1 && !vis[i]) {
					vis[i]=true;
					parent[i]=src;
					if(i==dest) {
						return;
					}
					q.add(i);
				}
			}
		}
	}
}