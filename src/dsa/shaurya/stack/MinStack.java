package dsa.shaurya.stack;

import java.util.Stack;

public class MinStack {
	LinkedListStack<Integer> elementStack = 
			new LinkedListStack<Integer>();
	LinkedListStack<Integer> minStack = 
			new LinkedListStack<Integer>();
	
	
	public void push(int data) {
		elementStack.push(data);
		if(minStack.isEmpty() ||  minStack.peek()>=data) {
			minStack.push(data);
		}else {
			minStack.push(minStack.peek());
		}
	}
	
	public int pop() {
		if(elementStack.isEmpty()) {
			return -1;
		}else {
			int temp = elementStack.pop();
			minStack.pop();
			return temp;
		}
	}
	
	public int getMin() {
		return minStack.peek()==null?-1:minStack.peek();
	}
	
	public int peek() {
		return getMin();
	}
	
	public static void main(String[] args) {
		MinStackOpt ms = new MinStackOpt();
		int a[] = {3,7,12,8,4,5,2};
		for(int i=0;i<a.length;i++) {
			ms.push(a[i]);
		}
		System.out.println(ms.getMin());
	}

}

class MinStackOpt{
	Stack<Integer> stack; 
	Integer minElement;
	MinStackOpt() { stack = new Stack<Integer>(); }
	
	public Integer getMin() {
		if(!stack.isEmpty()) {
			return minElement;
		}
		return null;
	}
	
	public void push(int x) {
		if(stack.isEmpty()) {
			stack.push(x);
			minElement=x;
			return;
		}
		if(x>=minElement) {
			//always insert greater number than min element
			stack.push(x);
		}else {
			//smaller number set to min but stack hold diff number
			minElement=x;
			stack.push(2*x-minElement);
		}
		
	}
	
	public Integer pop() {
		if(stack.isEmpty()) {
			return null;
		}
		
		int t = stack.pop();
		if(t<minElement) {
			int temp = minElement;
			minElement =2*minElement - t;
			return temp;
		}else {
			return t;
		}
	}
	
	
}
