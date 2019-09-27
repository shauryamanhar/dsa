package dsa.shaurya.recusion;

public class SudukoProblem {
	static final int D = 9;

	public static void main(String[] args) {
		int board[][] = {
				{0,0,0, 6,0,0, 0,5,4},
				{0,0,0, 0,0,5, 0,8,0},
				{6,0,1, 4,0,9, 3,7,0},

				{0,0,0, 0,0,6, 0,2,0},
				{3,0,0, 2,0,1, 0,0,6},
				{0,6,0, 5,0,0, 0,0,0},
				
				{0,1,6, 9,0,4, 8,0,7},
				{0,4,0, 1,0,0, 0,0,0},
				{2,8,0, 0,0,3, 0,0,0},
		};
		
		int n = 9;
		if(solveSuduko(board,n,0,0)) {
			System.out.println("solved");
		}else {
			System.out.println("fucked");
		}
		 
		print(board);
	}

	private static boolean solveSuduko(int[][] board, int n, int row, int col) {
		
		if(row==n) {
			//all solved
			System.out.println("row == n");
			return true;
		}
		
		if(col==n) {
			//go to next row
			return solveSuduko(board, n, row+1, 0);
		}
		
		
		int rootn = (int) Math.sqrt(n);
		for(int curNum = 1;curNum<=n;++curNum) {
			if(board[row][col]!=0) {
				//fixed numbers
				return solveSuduko(board, n, row, col+1);
			}
			if(canPlace(board,n,row,col,curNum)) {
				board[row][col] = curNum;
				boolean success = solveSuduko(board, n, row, col+1);
				if(success) {
					return true;
				}//if
				board[row][col]=0;
			}
		}//for
		return false;
	}

	private static boolean canPlace(int[][] board, int n, int row, int col, int curNum) {
		//vertical and horizontal check
		for(int x=0;x<n;x++) {
			if(board[row][x]==curNum) {
				return false;
			}
			if(board[x][col]==curNum) {
				return false;
			}
		}//for
		
		int rootn = (int) Math.sqrt(n);
		int boxRow = row/rootn;
		int boxCol = col/rootn;
		int boxStartCellRow = boxRow*rootn;
		int boxStartCellCol = boxCol*rootn;
		for(int i=boxStartCellRow;i<boxStartCellRow+rootn;++i) {
			for(int j=boxStartCellCol;j<boxStartCellCol+rootn;++j) {
				if(board[i][j]==curNum)
					return false;
			}
		}
		
		return true;
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
