package samsung;

import java.util.Scanner;

public class Amplification {

	public static void main(String[] args) {
		int n=3,m=3;
		int mat[][] = {
				{1,0,0},
				{1,0,1},
				{1,0,0}
		};
//		int k=2,col=0;
//		System.out.println(solve(mat,col,k,n,m));
	}
	void change(int m[][]) {
		
	}
	
	private static int solve(int mat[][],int col,int k,int n,int m) {
		int result = 0;
		if(k%2==0) {
			int count=0;
			int j=0;
			for(int i=0;i<n;i++) {
				for(j=0;j<m;j++) {
					if(mat[i][j]==0) {
						break;
					}
					if(j==m) {
						count++;
					}
				}
			}
			return count;
		}
		if(col==m || k==0) {
			return 0;
		}
		toggleCol(mat,col);
		result = Math.max(result,solve(mat,col+1,k-1,n,m));
		toggleCol(mat,col);
		result = Math.max(result,solve(mat,col+1,k,n,m));
		return result;
	}//solve
	
	
	private static void toggleCol(int mat[][],int col) {
		for(int i=0;i<mat.length;i++) {
			if(mat[i][col]==1) {
				mat[i][col]=0;
			}else {
				mat[i][col]=1;
			}
		}
	}//toggle
	
	static void print(int [][]a) {
		System.out.println("++++++");
		for(int r[]:a) {
			for(int j:r) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("++++++");
	}
	
}
