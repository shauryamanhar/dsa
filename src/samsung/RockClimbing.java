package samsung;

public class RockClimbing {
	int mat[][] = new int[51][51];
	boolean visited[][] = new boolean[51][51];
	int start[];
	int end[];
	int min_a;
	//start(x y) end(x y) sum min_a
	void dfs(int curr[],int end[],int sum) {
		int x = curr[0];
		int y = curr[1];
		visited[x][y] = true;
		//end condition
		if(x==end[0] && y==end[1]) {
			if(sum<min_a) {
				min_a=sum;
			}
			visited[x][y]=false;
		}//if
		
		
	}//dfs
	
}
