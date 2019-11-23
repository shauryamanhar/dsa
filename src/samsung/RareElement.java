package samsung;

import java.util.*;

public class RareElement {
	static final int MAX = 21;
	static int N,C;
	static int rare[][] = new int[8][2];
	static int visited[][][] = new int[8][MAX][MAX];
	static int mat[][] = new int[MAX][MAX];
	static class Pair{
		int x,y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}//pair
	static boolean inRange(int x,int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}//inRange
	
	static void bfs(int n,int x,int y) {
		java.util.Queue<Pair> q = new LinkedList<Pair>();
		x=x+1;
		y=y+1;
		visited[n][x][y]=0;
		q.add(new Pair(x,y));
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			x = temp.x;
			y = temp.y;
			if(inRange(x-1, y) && visited[n][x-1][y]==-1 && mat[x-1][y]==1) {
				q.add(new Pair(x-1,y));
				visited[n][x-1][y] = visited[n][x][y]+1;
			}
			if(inRange(x+1, y) && visited[n][x+1][y]==-1 && mat[x+1][y]==1) {
				q.add(new Pair(x+1,y));
				visited[n][x+1][y] = visited[n][x][y]+1;
			}
			if(inRange(x, y-1) && visited[n][x][y-1]==-1 && mat[x][y-1]==1) {
				q.add(new Pair(x,y-1));
				visited[n][x][y-1] = visited[n][x][y]+1;
			}
			if(inRange(x, y+1) && visited[n][x][y+1]==-1 && mat[x][y+1]==1) {
				q.add(new Pair(x,y+1));
				visited[n][x][y+1] = visited[n][x][y]+1;
			}
			
		}//while
		
		
	}//bfs
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		C = scan.nextInt();
		for(int i=0;i<C;i++) {
			rare[i][0] = scan.nextInt();
			rare[i][1] = scan.nextInt();
			rare[i][0]--;
			rare[i][1]--;
		}//rare elements
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<7;k++) {
					visited[k][i][j] = -1;
				}
			}
		}//for
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				mat[i][j] = scan.nextInt();
			}
		}//for
		
		
		for(int i=0;i<C;i++) {
				bfs(i,rare[i][0],rare[i][1]);
		}//bfs for all rare element
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(visited[1][i][j]+" ");
			}
			System.out.println();
		}
		int ans =-1,tsum = 0, ansMax=0;
		
		//TODO i dont know
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tsum = 0;
				for(int k=0,m=0;k<8;k++) {
					if(visited[k][i][j]==-1) {
						break;
					}//if
					
					tsum+=visited[k][i][j];
					m = Math.max(m, visited[k][i][j]);
					
					if(k==C-1) {
						if(ans==-1) {
							ans = tsum;
							ansMax = m;
						}else if(tsum<ans) {
							ans = tsum;
							ansMax = m;
						}
					}//if
					
					
				}//for
			}//for
		}//for
		
		System.out.println(ansMax);
		

	}//main

}
