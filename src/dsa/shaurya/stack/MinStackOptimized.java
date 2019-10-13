package dsa.shaurya.stack;

public class MinStackOptimized {
	LinkedListStack<Integer> elementStack = 
			new LinkedListStack<Integer>();
	LinkedListStack<Integer> minStack = 
			new LinkedListStack<Integer>();
	
	
	public void push(int data) {
		elementStack.push(data);
		if(minStack.isEmpty() ||  minStack.peek()>=data) {
			minStack.push(data);
		}
	}
	
	public int pop() {
		if(elementStack.isEmpty()) {
			return -1;
		}else {
			int temp = elementStack.pop();
			if(temp==minStack.peek()) {
				minStack.pop();
			}
			return temp;
		}
	}
	
	public int getMin() {
		return minStack.peek()==null?-1:minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStackOptimized ms = new MinStackOptimized();
		ms.push(2);
		ms.push(5);
		ms.push(8);
		ms.push(4);
		ms.push(2);
		ms.push(1);
		System.out.println("pop "+ms.pop());
		System.out.println("pop "+ms.pop());
		System.out.println("pop "+ms.pop());
		System.out.println("pop "+ms.pop());
		System.out.println(ms.getMin());

	}

}
