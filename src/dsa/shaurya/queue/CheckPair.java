package dsa.shaurya.queue;

import java.util.*;

public class CheckPair {

	public static void checkPair(Stack<Integer> stack) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean flag = true;
		while(!stack.isEmpty()) {
			int n= stack.pop();
			queue.add(n);
			if(!stack.isEmpty()) {
				int m = stack.pop();
				queue.add(m);
				if(Math.abs(n-m)!=1) {
					flag=false;
				}
				
			}
		}
		System.out.println(flag);
	}
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(1);
//		stack.push(2);
//		checkPair(stack);
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=11;i<=20;i++) {
			q.add(i);
		}
		interleaving(q);
	}//main
	
	
	public static void interleaving(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<Integer>();
		int size = queue.size();
		for(int i=0;i<size/2;i++) {
			stack.push(queue.remove());
		}
		for(int i=0;i<size/2;i++) {
			queue.add(stack.pop());
		}
		for(int i=0;i<size/2;i++) {
			queue.add(queue.remove());
		}
		for(int i=0;i<size/2;i++) {
			stack.push(queue.remove());
		}
		
		for(int i=0;i<size/2;i++) {
			queue.add(stack.pop());
			queue.add(queue.remove());
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		
	}

}//class
