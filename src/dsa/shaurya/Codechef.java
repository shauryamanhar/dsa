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
		int maxStar = Integer.MIN_VALUE,count=0;
		for(int i=0;i<n;i++) {
			count=0;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]%arr[i]==0) {
					count++;
				}
			}//for
			
			if(maxStar<count) {
				maxStar = count;
			}
			
		}
		System.out.println(maxStar);
	}//solve
}//codechef
