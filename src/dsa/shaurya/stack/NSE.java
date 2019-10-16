package dsa.shaurya.stack;

import java.util.Stack;

public class NSE {
	public static void findNextSmallerElement(int a[],int n) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(a[0]);
		int temp; 
		int next;
		for(int i=1;i<n;i++) {
			next = a[i];
			while(!stack.isEmpty() && next<=stack.peek()) {
				temp = stack.pop();
				System.out.println(temp+" -> "+next);
			}
			stack.push(next);
		}
		while(!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(temp+" -> "+-1);
		}
	} 
	public static void main(String[] args) {
		int a[] = {13,7,6,12};
		findNextSmallerElement(a,a.length);
	}

}
