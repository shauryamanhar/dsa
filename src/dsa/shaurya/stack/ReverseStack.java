package dsa.shaurya.stack;

import java.util.Stack;
public class ReverseStack {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void reverse() {
		int data;
		if(!stack.isEmpty()) {
			data = stack.pop();
			reverse();
			insertAtButtom(data);
		}
	}
	
	public static void insertAtButtom(int data) {
		if(stack.isEmpty()) {
			stack.push(data);
		}else {
			int temp = stack.pop();
			insertAtButtom(data);
			stack.push(temp);
		}
	}
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		reverse();
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}

}
