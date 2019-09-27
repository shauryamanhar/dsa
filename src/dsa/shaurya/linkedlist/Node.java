package dsa.shaurya.linkedlist;

public class Node {
	int data;
	Node next = null;
	Node(int data){
		this.data=data;
	}
	
	public void setData(int data) {
		this.data=data;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}

