package dsa.shaurya.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ZetaAndThanosv {
	static int n,m;
	static int mat[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		mat = new int[n][m];
		String str = null;
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String s[] = sc.nextLine().split(" ");
			for(int j=0;j<m;j++) {
				if(s[j].equals("*")) {
					mat[i][j]=-1;
				}else {
					mat[i][j]=Integer.parseInt(s[j]);
				}
			}
		}
		
		int sx,sy;
		sx = sc.nextInt()-1;
		sy = sc.nextInt()-1;
		
		int q,dx,dy;
		q=sc.nextInt();
		for(int i=0;i<q;i++) {
			dx = sc.nextInt()-1;
			dy = sc.nextInt()-1;
			bfs(sx, sy, dx, dy);
		}
		
	}//main
	static void bfs(int sx,int sy,int dx,int dy) {
		Queue<P> q = new LinkedList<P>();
		boolean vis[][] = new boolean[n][m];
		int d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
		if(true)
			break;
		q.add(new P(sx,sy));
		vis[sx][sy]=true;
		int cost=0;
		while(!q.isEmpty()) {
			P p = q.poll();
			sx = p.x;
			sy = p.y;
			System.out.println("vis "+sx+" "+sy);
			cost+=mat[sx][sy];
			if(sx==dx && dx==dy) {
				break;
			}
			for(int i=0;i<d.length;i++) {
				for(int j=0;j<d[0].length;j++) {
					if(isSafe(sx+d[i][j], sy+d[i][j]) && !vis[sx+d[i][j]][sy+d[i][j]] && mat[sx+d[i][j]][sy+d[i][j]]!=-1){
						q.add(new P(sx+d[i][j],sy+d[i][j]));
						vis[sx+d[i][j]][sy+d[i][j]]=true;
					}
				}
			}
		}
		System.out.println("cost "+cost);
		
	}
	static boolean isSafe(int x,int y) {
		if(x>=0 && y>=0 && x<n && y<m) {
			return true;
		}else {
			return false;
		}
	}//safe
	static class P{
		int x,y;
		P(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
}
