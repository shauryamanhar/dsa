package dsa.shaurya.stack;

public class ArrayStack {
	int top;
	int capacity;
	int []array=null;
	
	public ArrayStack(int capacity) {
		this.capacity=capacity;
		this.top=-1;
		this.array = new int[capacity];
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public boolean isFull() {
		return top==capacity-1;
	}
	
	public Integer push(int data) {
		if(isFull()) {
			return null;
		}else {
			array[++top]=data;
			return data;
		}
	}
	
	public Integer pop() {
		if(isEmpty()) {
			return null;
		}else {
			return array[top--];
		}
	}
	
	public Integer peek() {
		if(isEmpty()) {
			return null;
		}else {
			return array[top];
		}
	}
	
}//stack
