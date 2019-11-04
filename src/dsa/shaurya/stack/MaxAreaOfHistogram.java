package dsa.shaurya.stack;

import java.util.Stack;

public class MaxAreaOfHistogram {

	public static int findMaxTheArea(int a[],int n){
		int i=0;
		int maxArea=-1;
		Stack<Integer> stack = new Stack<Integer>();
		while(i<n) {
			if(stack.isEmpty() || a[i]>=a[stack.peek()]) {
				stack.push(i++);
			}else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, a[top]*(stack.isEmpty()?i:i-stack.peek()-1));
			}
		}
		while(!stack.isEmpty()) {
			int top = stack.pop();
			maxArea = Math.max(maxArea, a[top]*(stack.isEmpty()?i:i-stack.peek()-1));
		}
		return maxArea;
	}
	
	public static int findMaxTheAreaArray(int a[],int n){
		int i=0;
		int maxArea=0;
		int stack[] = new int[n];
		int top=-1;
		while(i<n) {
			if(top<0 || a[i]>=a[stack[top]]) {
				stack[++top]=i++;
			}else {
				int temp = stack[top--];
				maxArea = Math.max(maxArea, a[temp]*(top==-1?i:i-stack[top]-1));
			}
		}
		while(top==-1) {
			int temp = stack[top--];
			maxArea = Math.max(maxArea, a[temp]*(top==-1?i:i-stack[top]-1));
		}
		return maxArea;
	}
	
	
	
	
	public static void print(int a[]) {
		for(int r:a) {
			System.out.print(r+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a[] = {11, 11, 10, 10, 10};
//		int a[] = {1,2,3,1};
		System.out.println(findMaxTheArea(a,a.length));
		System.out.println(findMaxTheAreaArray(a,a.length));
	}

}

//int top = -1;
//int maxArea=-1;
//int i=0;
//int n=a.length;
//int stack[] = new int[n];
//while(i<n){
//    if(top<0 || a[i]>stack[top]){
//        stack[++top]=i++;
//    }else{
//        int temp = stack[top--];
//        maxArea = Math.max(maxArea,a[temp]*(top<0?i:i-stack[top]-1));
//    }
//}//while
//
//while(top>0){
//    int temp = stack[top--];
//    maxArea = Math.max(maxArea,a[temp]*(top<0?i:i-stack[top]-1));
//}
//return maxArea;
