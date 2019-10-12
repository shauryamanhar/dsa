package dsa.shaurya;

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
			int n = scan.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = scan.nextInt();
			}
			solve(n,arr);
		}//while
	}//main
	
	public static void solve(int n,int []arr){
		int gMin = arr[0];
		int count=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=i,k=i-5;k>=0 && j>=k;j--) {
				if(gMin>=arr[j]) {
					count++;
					gMin=arr[j];
					System.out.println(gMin);
				}
			}
			System.out.println();
		}
		System.out.println(count);
		
	}//solve
}//codechef
