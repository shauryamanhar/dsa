package dsa.shaurya.stack;

import dsa.shaurya.stack.ArrayStack;

public class Main {
	public static void main(String[] args) throws Exception {
		LinkedListStack<Integer> as = new LinkedListStack<Integer>();
		as.push(1);
		as.push(2);
		as.push(3);
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		as.push(4);
	}
}
