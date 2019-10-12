package dsa.shaurya.stack;

public class LinkedListStack<T> {
	Node top;
	private class Node{
		T data;
		Node next;
	}
	
	public Boolean isEmpty() {
		return top==null;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}else {
			return top.data;
		}
	}
	
	public void push(T data) {
		Node newNode = new Node();
		newNode.data = data;
		
		Node temp = top;
		newNode.next = top;
		top = newNode;
	}
	
	public T pop() {
		if(isEmpty()) {
			top=null;
			return null;
		}else {
			Node temp = top;
			top = top.next;
			return temp.data;
		}
	}
	
	
}
