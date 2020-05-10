package dsa.shaurya.specialalgorithm;

public class LUDecomposition {

	public static void main(String[] args) {
		int a[][] = {{2,3,1,5},{6,13,5,19},{2,19,10,23},{4,10,11,31}};
//		int a[][] = {{4,-5,6},{8,-6,7},{12,-7,12}};
		int n = a.length;
		int l[][] = new int[n][n];
		int u[][] = new int[n][n];
		luDecompostion(a, l, u);
		System.out.println("++++++A+++++++");
		print(a);
		System.out.println("++++++Lower+++++++");
		print(l);
		System.out.println("++++++Upper+++++++");
		print(u);
	}
	
	static void print(int a[][]) {
		for(int r[]:a) {
			for(int j:r) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	static void luDecompostion(int a[][],int l[][],int u[][]) {
		int n = a.length;
		//U zeros below the diagonal
		//setting diagonal 1 for L and and above the diagonal 0
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					l[i][j]=1;
			}
		}
		for(int k=0;k<n;k++) {
			u[k][k]=a[k][k];//selecting pivot
			for(int i=k+1;i<n;i++) {
				u[k][i]=a[k][i];//u[k][i] holds w^t
				l[i][k]=a[i][k]/u[k][k];//l(i,k) holds v(i)
			}
			//update schur complement
			for(int i=k+1;i<n;i++) {
				for(int j=k+1;j<n;j++) {
					a[i][j]=a[i][j]-l[i][k]*u[k][j];//silly mistake
				}
			}
		}
	}//LU
	
	void lupSolve(int l[][],int u[][],int pi[],int b[]) {
		int n = l.length;
		int x[] = new int[n];
		
		for(int i=0;i<n;i++) {
			
		}
	}

}
