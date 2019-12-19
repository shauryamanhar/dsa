package samsung;
import java.util.Scanner;
public class Test2 {
	static int ans=0;//make this global
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		int testcase= scan.nextInt();
		while(testcase>0){
			int rows= scan.nextInt();
			int cols= scan.nextInt();
			int k= scan.nextInt();
			int matrix[][]= new int[rows][cols];
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					matrix[i][j]=scan.nextInt();
				}
			}
			solve(matrix,k,cols,rows,0);
			System.out.println("ans "+ans);//answer will be in static int ans
			testcase--;
		} // while
		scan.close();
	}
	//make matrix, cols and rows global
	public static void toggle(int col, int matrix[][], int rows){
		for(int i=0;i<rows;i++){
			if(matrix[i][col]==1){
				matrix[i][col]=0;
			}else{
				matrix[i][col]=1;
			}
				
		}
			
	}
	//remove ans because it is global
	public static int solve(int matrix[][], int k, int cols, int rows, int col){
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
			if(count>ans)
				ans= count;
			result=count;
			//wrong return statement; because we are just counting the rows it 
			//return result
			
		} //if
		if(col==cols || k==0)
			return 0;
		
		toggle(col,matrix,rows);
		result=Math.max(result, solve(matrix,k-1,cols,rows,col+1));
		toggle(col,matrix,rows);
		result=Math.max(result, solve(matrix,k,cols,rows,col+1));
		return result;
	} //solve
}   //class
