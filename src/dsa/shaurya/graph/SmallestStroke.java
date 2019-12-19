package dsa.shaurya.graph;
import java.util.*;

class SmallestStroke {
	static int row=0,col=0;
	static char [][] arr;
	static boolean visited[][];
	static int counter[][];
	static int cn=0;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("avaaba");
		list.add("avaaba");
		list.add("bbabbc");
		list.add("bbabbc");
		solve(list);
		System.out.println("Stroke count "+cn);
	}
	
	
	static int solve(List<String> list)  {
		row = list.size();
		col = list.get(0).length();
		arr = new char[row][col];
		int r=0;
		for(String s:list) {
			for(int j=0;j<col;j++) {
				arr[r][j]=s.charAt(j);
			}
			r++;
		}
		
		visited = new boolean[row][col];
		counter = new int[row][col];
		cn=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				bfs(i,j);
			}
		}
		System.out.println("======");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(counter[i][j]);
			}
			System.out.println();
		}
		
		return ans;
	}
	
	static boolean isSafe(int x,int y) {
		if(x>=0 && x<row && y>=0 && y<col && visited[x][y]==false) {
			return true;
		}else {
			return false;
		}
	}//isSafe
	
	static void bfs(int x,int y)  {
		Queue<Pair> q = new LinkedList<Pair>();
		char currChar = arr[x][y]; 
		if(visited[x][y]==true) {
			return;
		}
		cn++;
		int count=0;
		visited[x][y] =true;
		q.add(new Pair(x,y));
		while(!q.isEmpty()) {
			count++;
			//counting
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			counter[x][y]=cn;
//			try {
//				Thread.sleep(0);
//				System.out.println("running char "+currChar+"  x "+x+"  y "+y);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//up
			if(isSafe(x-1,y) && arr[x-1][y]==currChar) {
				visited[x-1][y] = true;
				q.add(new Pair(x-1,y));
			}
			//down
			if(isSafe(x+1,y) && arr[x+1][y]==currChar) {
				visited[x+1][y] = true;
				q.add(new Pair(x+1,y));
			}
			//left
			if(isSafe(x,y-1) && arr[x][y-1]==currChar) {
				visited[x][y-1] = true;
				q.add(new Pair(x,y-1));
			}
			//right
			if(isSafe(x,y+1) && arr[x][y+1]==currChar) {
				visited[x][y+1] = true;
				q.add(new Pair(x,y+1));
			}
			
		}//while
		if(count<ans) {
			ans = count;
		}
	}//bfs
	
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}//pair
}


/*
a a a a b a
a a a b b a
b b c c c b
b b b b b b 
*/