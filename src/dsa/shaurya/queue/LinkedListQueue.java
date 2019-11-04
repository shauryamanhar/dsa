package dsa.shaurya.queue;

import java.util.Stack;

public class LinkedListQueue {
	private int size=0;
	
	private Node front=null;
	private Node rear=null;
	
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}//node
	
	
	public void push(int data) {
		Node newNode = new Node(data);
		if(front==null) {
			front=newNode;
			rear=front;
		}else {
			rear.next = newNode;
			rear=newNode;
		}
		size++;
	}
	
	public int pop() {
		Node temp=null;
		if(front==null) {
			return -1;
		}else {
			temp = front;
			front=front.next;
			size--;
			return temp.data;
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public static void main(String[] args) {
		LinkedListQueue q = new LinkedListQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println("pop "+q.pop());
		System.out.println("pop "+q.pop());
		System.out.println("pop "+q.pop());
		q.push(4);
		System.out.println("size "+q.size);
		int data=0;
		while(q.isEmpty()==false) {
			data=q.pop();
			System.out.println(data);
		}
	
	}
	
	
}
