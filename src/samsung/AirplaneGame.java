package samsung;

import java.util.Scanner;

public class AirplaneGame {
	
	 static int maxCoins = -1;
	 static int coins = -1;
	
	 static int a[][];
	 static int b[][] = new int[5][5];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t,n;
		t = scan.nextInt();
		while(t-->0){
			n = scan.nextInt();
			maxCoins = -1;
			a = new int[n+1][5];
			for(int j=0;j<n;j++){
				for(int k=0;k<5;k++) {
					a[j][k]=scan.nextInt();
				}
			}//for
			
//			for(int j=0;j<5;j++) {
//				a[n][j]=0;
//			}
			//placing A in last row(n)
			a[n][2]=2;
//			System.out.println("a[0]"+a[0][0]);
			for(int j=n-1;j>0;j--) {
				coins=-1;
				detonate(j);
				getMaxCoins(2, 0, n);
				unDetonate(j);
				
			}
			System.out.println(maxCoins);
			
			
		}
		scan.close();
	}//main
	
	 static void getMaxCoins(int pos,int coins,int n) {
		if(pos<0 || pos>4 || coins<0) {
			return;
		}
		if(a[n-1][pos]==2) {
			coins-=1;
		}else if(a[n-1][pos]==1) {
			coins+=1;
		}
		
		if(n==1) {
			if(coins>maxCoins) {
				maxCoins=coins;
			}
			return;
		}else {
			//3 movesW
			getMaxCoins(pos+1, coins, n-1);
			getMaxCoins(pos-1, coins, n-1);
			getMaxCoins(pos, coins, n-1);
		}
		
	}
	
	 static void detonate(int row) {
		for(int i=row;i>row-5 && i>=0;i--) {
			for(int j=0;j<5;j++) {
				b[row - i][j] = 0; 
				if (i >= 0 && a[i][j] == 2){
					b[row - i][j] = 2;
					a[i][j] = 0;
				}   
			}
		}//for
	}
	 static void unDetonate(int row) {
		for(int i=row;i>row-5 && i>=0;i--) {
			for(int j=0;j<5;j++) {
				if (i >= 0 && b[row-i][j] == 2){
					a[i][j] = 2;
				}   
			}
		}//for
	}
	static void print(int a[][]) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
