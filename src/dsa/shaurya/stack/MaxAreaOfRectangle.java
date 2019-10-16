package dsa.shaurya.stack;

import java.util.Stack;

public class MaxAreaOfRectangle {

	public static void findMaxArea(int a[],int n) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for(int i=0;i<n;i++) {
			if(stack.isEmpty() || a[i]>=stack.peek()) {
				stack.push(i);
			}else {
				int top = stack.pop();
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		int a[] = {3,2,5,6,1,4,4};
		findMaxArea(a,a.length);

	}

}
