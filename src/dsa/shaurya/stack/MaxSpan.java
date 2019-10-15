package dsa.shaurya.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxSpan {
	public static void findMaxSpan(int a[]) {
		int i,j,n=a.length;
		int s[] = new int[n];
		int min=-1;
		for(i=0;i<n;i++) {
			j=1;
			while(j<=i && a[i]>a[i-j]) {
				j++;
			}
			s[i]=j;
			if(min<s[i]) {
				min=s[i];
			}
		}
		System.out.println("min is "+min);
	}
	public static void findMaxSpanUsingStacks(int a[]) {
		Stack<Integer> stack = new Stack<>();
		int s[] = new int[a.length];
		int min=-1;
		for(int i=0;i<a.length;i++) {
			if(stack.isEmpty()) {
				stack.push(a[i]);
			}else {
					while(!stack.isEmpty() && stack.peek()>a[i]) {
						stack.pop();
					}
					stack.push(a[i]);
					if(min<stack.size()) {
						min=stack.size();
					}
			}
		}
		System.out.println(stack.size()+1);
	}
	public static void main(String[] args) {
		int arr[] = {6,3,4,1,5,1,2,7};
		findMaxSpan(arr);
		findMaxSpanUsingStacks(arr);
	}
}
