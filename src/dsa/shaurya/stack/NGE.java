package dsa.shaurya.stack;

import java.util.Stack;

public class NGE {
	
	public static void findNextGreaterElement(int a[]) {
		int n = a.length;
		int next = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(a[0]);
		for(int i=1;i<n;i++) {
			next = a[i];
			while(!stack.isEmpty() && next >=stack.peek()) {
				int temp = stack.pop();
				System.out.println(temp+" -> "+next);
			}
			stack.push(next);
		}
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			System.out.println(temp+" -> "+-1);
		}
	}
	
	public static void main(String[] args) {
		int a[] = {3,7,1,8,4,5,2};
		findNextGreaterElement(a);
	}

}