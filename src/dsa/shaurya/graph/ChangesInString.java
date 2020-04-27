//https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/ab-string-5f6b213a/
package dsa.shaurya.graph;

import java.util.*;

public class ChangesInString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			long pre[] = new long[n];
			long suff[] = new long[n];
			
			pre[0]=(s.charAt(0)=='A'?1L:0L);
			for(int i=1;i<n;i++) {
				pre[i]=pre[i-1]+((s.charAt(i)=='A'?1L:0L));
			}
			
			suff[n-1]=(s.charAt(n-1)=='B'?1L:0L);
			for(int i=n-2;i>=0;i--) {
				suff[i]=suff[i+1]+(s.charAt(i)=='B'?1L:0L);
			}
			long sum = suff[0];
			for(int i=1;i<n;i++) {
				sum = Math.max(sum, pre[i-1]+suff[i]);
			}
			sum = Math.max(sum, pre[n-1]);
			System.out.println(n-sum);
		}
	}//main
}
