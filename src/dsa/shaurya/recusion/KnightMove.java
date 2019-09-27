package dsa.shaurya.recusion;

public class KnightMove {

	static int count=0;
	public static void main(String[] args) {
		final int d = 8;
		int board[][] = new int[d][d];
		
		int moveNumber = 1;
		int n = 8;
		
		//starting point
		int x = 0;
		int y = 0;
		board[x][y] = 1;
		System.out.println(solveKnight(board,n,moveNumber,x,y));
		print(board);

	}

	private static boolean solveKnight(int[][] board, int n, int moveNumber, int currRow, int currCol) {
		if(moveNumber==n*n) {
			//complete all moves
			return true;
		}
		
		int rowDir[] = {+2,+1,-1,-2,-2,-1,+1,+2};
		int colDir[] = {+1,+2,+2,+1,-1,-2,-2,-1};
		
		for(int currDir=0;currDir<rowDir.length;currDir++) {
			int nextRow = currRow+rowDir[currDir];
			int nextCol = currCol+colDir[currDir];
			
			if(canPlace(board,n,nextRow,nextCol)) {
				board[nextRow][nextCol] = moveNumber+1;
				boolean isSuccessful = solveKnight(board,n,moveNumber+1, nextRow, nextCol);
				if(isSuccessful) {
					return true;
				}
				board[nextRow][nextCol] = 0;
			}
		}
		return false;
	}

	private static boolean canPlace(int[][] board, int n, int nextRow, int nextCol) {
		return nextRow>=0 && nextRow <n
				&&
				nextCol>=0 && nextCol<n
				&&
				board[nextRow][nextCol]==0;
	}
	
	private static void print(int board[][]) {
		System.out.println("=============");
		for(int row[] :board) {
			for(int col:row) {
				System.out.print(col+"     ");
			}
			System.out.println();
		}
		System.out.println("=============");
	}

}
