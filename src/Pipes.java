import java.util.*;
	class Pair{
		int xCord;
		int yCord;
		int l;
	}
public class Pipes{
	static int L;
	static int[][] matrix;
	static boolean[][] visited;
	static int ans;
	static int row,col;
	
	static boolean inRange(int x,int y){
		return (x>=0 && x<row && y>=0 && y<col);
	}
	
	static boolean right(int x,int y){
		return (matrix[x][y] == 1 || matrix[x][y] == 3|| matrix[x][y] == 4 || matrix[x][y] == 5);
	}
	static boolean left(int x,int y){
		return (matrix[x][y] == 1 || matrix[x][y] == 3|| matrix[x][y] == 6 || matrix[x][y] == 7);
	}
	static boolean up(int x,int y){
		return (matrix[x][y] == 1 || matrix[x][y] == 2|| matrix[x][y] == 4 || matrix[x][y] == 7);
	}
	static boolean down(int x,int y){
		return (matrix[x][y] == 1 || matrix[x][y] == 2|| matrix[x][y] == 5 || matrix[x][y] == 6);
	}
	
	static void flow(int x,int y){
		Pair p = new Pair();
		p.xCord = x;
		p.yCord = y;
		p.l = L;
		visited[x][y] = true;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(p);
		int l;
		while(!q.isEmpty()){
			p = q.poll();
			x = p.xCord;
			y = p.yCord;
			l = p.l;
			if(l==0){
				return ;
			}
			ans++;
			if(inRange(x-1,y) && !visited[x-1][y] && up(x,y) && down(x-1,y)){
				System.out.printf("UP x %d y %d arr[%d]\n",x,y,matrix[x][y]);
				visited[x-1][y] = true;
				p.xCord = x-1;
				p.yCord = y;
				p.l = l-1;
				q.add(p);
			} 
			if(inRange(x+1,y) && !visited[x+1][y] && down(x,y) && up(x+1,y)){
				System.out.printf("DOWN x %d y %d arr[%d]\n",x,y,matrix[x][y]);
				visited[x+1][y] = true;
				p.xCord = x+1;
				p.yCord = y;
				p.l = l-1;
				q.add(p);
			} 
			if(inRange(x,y-1) && !visited[x][y-1] && left(x,y) && right(x,y-1)){
				System.out.printf("LEFT x %d y %d arr[%d]\n",x,y,matrix[x][y]);
				visited[x][y-1] = true;
				p.xCord = x;
				p.yCord = y-1;
				p.l = l-1;
				q.add(p);
			} 
			if(inRange(x,y+1) && !visited[x][y+1] && right(x,y) && left(x,y+1)){
				System.out.printf("RIGHT x %d y %d arr[%d]\n",x,y,matrix[x][y]);
				visited[x][y+1] = true;
				p.xCord = x;
				p.yCord = y+1;
				p.l = l-1;
				q.add(p);
			} 
		}
	}
	
public static void main(String args[]){
    int t,x,y;
	Scanner scan = new Scanner(System.in);
	t = scan.nextInt();
	for(int i=0;i<t;i++){
		row = scan.nextInt();
		col = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		L = scan.nextInt();
		matrix = new int[row][col];
		visited = new boolean[row][col];
		ans= 0;
		for(int k=0;k<row;k++){
			for(int j=0;j<col;j++){
				matrix[k][j] = scan.nextInt();
			}
		}
		if(matrix[x][y] !=0 )
			flow(x,y);
		System.out.println((i+1)+"# "+ans);
	}
}
}