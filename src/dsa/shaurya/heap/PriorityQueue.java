package dsa.shaurya.heap;

public class PriorityQueue {
	private int size=0;
	private int capacity=100_00_0;
	private int heap[];
	public PriorityQueue() {
		this.heap = new int[capacity];
		this.size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void insert(int data) {
		if(size()<=capacity) {
			heap[size]=data;
			size++;
			heapifyUp(size-1);
		}
	}
	public int getMin() {
		if(!isEmpty()) {
			return heap[0];
		}
		return -1;
	}
	public int removeMin() {
		int data = -1; 
		if(!isEmpty()) {
			data = heap[0];
			heap[0] = heap[size-1];
			heap[size-1]=-1;
			size--;
			heapifyDown(0);
		}
		return data;
	}
	private void heapifyUp(int index) {
		int parent = (index-1)/2;
		if(parent==0) {
			return;
		}
		if(heap[parent]<heap[index]) {
			int temp = heap[parent];
			heap[index] = heap[parent];
			heap[parent] = temp;
			heapifyUp(parent);
		}
	}
	private void heapifyDown(int index) {
		int left = 2*index+1;
		int right = 2*index+2;
		int min = index;
		if(left>=0 && left<capacity && heap[left]<heap[index]) {
			min = left;
		}
		if(right>=0 && right<capacity && heap[right]<heap[min]) {
			min = right;
		}
		if(min!=index) {
			int temp = heap[min];
			heap[min] = heap[index];
			heap[index] = temp;
			heapifyDown(min);
		}
	}
	private void print() {
		for(int i=0;i<size();i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PriorityQueue p = new PriorityQueue();
		p.insert(5);
		p.insert(9);
		p.insert(9);
		p.insert(6);
		p.print();
		System.out.println("==========");
		for(int i=0;i<p.size();i++) {
			System.out.println(p.removeMin());
		}
		p.print();
	}
	
}
