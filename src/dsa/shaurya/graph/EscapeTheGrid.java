package dsa.shaurya.graph;
import java.util.*;
public class EscapeTheGrid {
	
	class Pair{
		int x,y,distance;
		Pair(int x,int y,int dis){
			this.x=x;this.y=y;this.distance=dis;
		}
	}//pair
	
	int [][]grid;
	int row,col;
	
	public EscapeTheGrid(int row,int col) {
		grid = new int[row][col];
		this.row=row;
		this.col=col;
	}//escape
	
	boolean isSafe(int x,int y) {
		if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==0) {
			return true;
		}else {
			return false;
		}
	}//is safe
	
	boolean isCorner(int x,int y) {
		if(x==0 || x==row-1 || y==0 || y==col-1) {
			return true;
		}else {
			return false;
		}
	}
	
	int bfs() {
		//location of 2
		int x=0,y=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(grid[i][j]==2) {
					x = i;
					y = j;
				}
			}
		}//for
//		System.out.println();
		System.out.println("found x and y "+x+" "+y);
		
		if(isCorner(x, y)) {
			return 0;
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y,0));
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			if(q.size()>row*col) {
				return -1;
			}
			System.out.println("queue size "+q.size());
			System.out.println("queued "+pair.x+" "+pair.y);
			//up
			if(isSafe(pair.x-1, pair.y)) {
				q.add(new Pair(pair.x-1,pair.y,pair.distance+1));
			}
			//down
			if(isSafe(pair.x+1, pair.y)) {
				q.add(new Pair(pair.x+1,pair.y,pair.distance+1));
			}
			//left
			if(isSafe(pair.x, pair.y-1)) {
				q.add(new Pair(pair.x,pair.y-1,pair.distance+1));
			}
			//right
			if(isSafe(pair.x, pair.y+1)) {
				q.add(new Pair(pair.x,pair.y+1,pair.distance+1));
			}
			
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		EscapeTheGrid e = new EscapeTheGrid(row, col);
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				e.grid[i][j] = scan.nextInt();
			}
		}//for
		System.out.println(e.bfs());
	}

}
