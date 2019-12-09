package samsung;
import java.util.Scanner;
public class Test {

	static int cols;
	static int rows;
	static int matrix[][];
	static int ans=0;
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		int testcase= scan.nextInt();
		while(testcase>0){
			rows= scan.nextInt();
			cols= scan.nextInt();
			int k= scan.nextInt();
			matrix= new int[rows][cols];
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					matrix[i][j]=scan.nextInt();
				}
			}
			solve(k,0);
			System.out.println("ans "+ans);
//			print(matrix);
			testcase--;
		} // while
		scan.close();
	}
	public static void toggle(int col){
		for(int i=0;i<rows;i++){
			if(matrix[i][col]==1){
				matrix[i][col]=0;
			}else{
				matrix[i][col]=1;
			}
		}
	}
	public static int solve(int k,int col){
//		print(matrix);
		int result=0;
		if(k%2==0){
			int count=0;
			int j;
			for(int i=0;i<rows;i++){
				for( j=0;j<cols;j++){
					if(matrix[i][j]!=1)
						break;
				}
				if(j==cols)
					count++;
			}
			System.out.println("count "+count+" ans "+ans);
			if(count>ans) {
				ans= count;
			}
			result=count;
		} //if
		if(col==cols || k==0) {
			return 0;
		}
		toggle(col);
		result=Math.max(result, solve(k-1,col+1));
		toggle(col);
		result=Math.max(result, solve(k,col+1));
		return result;
	} //solve
	
	static void print(int mat[][]) {
		for(int r[]:mat) {
			for(int c:r) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
}   //class
