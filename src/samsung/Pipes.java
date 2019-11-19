package samsung;

import java.util.*;
public class Pipes {

	static int arr[][]=null;
	static boolean visited[][]=null;
	static int X=0,Y=0,L=0,row=0,col=0,ans=0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int t = scan.nextInt();
		while(t-->0) {
			row = scan.nextInt();
			col = scan.nextInt();
			
			X = scan.nextInt();
			Y = scan.nextInt();
			L = scan.nextInt();
			
			arr = new int[row][col];
			visited = new boolean[row][col];
			ans = 0;
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j]=scan.nextInt();
				}
			}
			if(arr[X][Y]>0) {
				flow(X,Y,L);
			}
			System.out.println("#"+(t+1)+" "+ans);
			
		}//while

	}//main
	

	static void flow(int x,int y,int l) {
		if(l==0) {
			return;
		}
		
		if(visited[x][y]==false) {
			ans++;
		}
		
		visited[x][y]=true;
		
		if(inRange(x-1,y) && up(x,y) && down(x-1,y)) {
			//going down
			flow(x-1,y,l-1);
		}
		if(inRange(x+1,y) && down(x,y) && down(x+1,y)) {
			//going up
			flow(x+1,y,l-1);
		}
		if(inRange(x,y-1) && right(x,y) && left(x,y-1)) {
			//going left
			flow(x,y-1,l-1);
		}
		if(inRange(x,y+1) && left(x,y) && right(x,y+1)) {
			//going right
			flow(x,y+1,l-1);
		}
		
	}//flow
	
	
	static boolean inRange(int x,int y) {
		return (x>=0 && x<row && y>=0 && y<col);
	}//inRange
	
	static boolean right(int x,int y) {
		return (arr[x][y]==1 || arr[x][y]==3 || arr[x][y]==4 || arr[x][y]==5);
	}//right
	static boolean left(int x,int y) {
		return (arr[x][y]==1 || arr[x][y]==3 || arr[x][y]==6 || arr[x][y]==7);
	}//left
	static boolean up(int x,int y) {
		return (arr[x][y]==1 || arr[x][y]==2 || arr[x][y]==4 || arr[x][y]==7);
	}//up
	
	static boolean down(int x,int y) {
		return (arr[x][y]==1 || arr[x][y]==2 || arr[x][y]==5 || arr[x][y]==6);
	}//down
	
}
