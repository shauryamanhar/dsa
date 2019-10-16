package dsa.shaurya;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int x=scan.nextInt();
		
		long a[] = new long[n];
		
		for(int i=0;i<n;i++) {
			a[i] =scan.nextLong();
		}
		
		System.out.println(findMax(a,n, x));

	}
	public static long findMax(long a[],int n,int k){
		int top = 0;
        long stacksum = 0;
        for(int i=0;i<k;i++){
            stacksum+=a[top++];
        }
        long gmax = stacksum;
        int r=1;
        while(r<=k-1){
            stacksum=stacksum-a[--top];
            stacksum=stacksum+a[n-r];
            gmax = Math.max(stacksum,gmax);
            r++;
        }
        return gmax;
    }
}
