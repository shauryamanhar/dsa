package dsa.shaurya.heap;

public class Heap {
	public static void main(String[] args) {
		int a[] = {11,2,3,4,5,70,8};
		Heap h = new Heap(a);
		h.insert(1);
		h.insert(2);
		h.insert(3);
		h.insert(2);
		h.insert(1);
		h.deleteMax();
		print(h.arr);
		System.out.println(h.getMax());
	}
	int arr[];
	int count;
	int capacity;
	
	Heap(int capacity){
		this.capacity=capacity;
		this.arr = new int[capacity];
		this.count=0;
	}
	Heap(int a[]){
		this.capacity=a.length;
		this.count=a.length;
		this.arr = new int[a.length];
		buildHeap(a);
	}
	
	int getMax() {
		return arr[0];
	}
	
	int leftChild(int i) {
		int left = 2*i+1;
		if(left>=count) {
			return -1;
		}
		return left;
	}
	int rightChild(int i) {
		int right = 2*i+2;
		if(right>=count) {
			return -1;
		}
		return right;
	}
	void percolateDown(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int max;
		if(left!=-1 && arr[left]>arr[i]) {
			max = left;
		}else {
			max = i;
		}
		if(right!=-1 && arr[right]>arr[max]) {
			max = right;
		}
		
		if(max!=i) {
			//swapping
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			percolateDown(max);
		}
	}
	
	void resize() {
		int oldSize = count;
		int oldArr[] = arr;
		arr = new int[capacity*2];
		for(int i=0;i<oldSize;i++) {
			arr[i] = oldArr[i];
		}
		this.capacity = capacity*2;
	}
	
	void insert(int data) {
		if(count==capacity) {
			resize();
		}
		count++;
		int i = count-1;
		while(i>0 && data>arr[(i-1)/2]) {
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
		}
		arr[i] = data;
	}
	int deleteMax() {
		if(count==0) {
			return -1;
		}
		int data = arr[0];
		count--;
		arr[0] = arr[count];
		arr[count]=0;
		percolateDown(0);
		return data;
	}
	
	void buildHeap(int a[]) {
		while(this.capacity==a.length) {
			resize();
		}
		for(int i=0;i<a.length;i++) {
			this.arr[i]=a[i];
		}
		this.count=arr.length;
		print(arr);
		
		for(int i=(count-1)/2;i>=0;i--) {
			percolateDown(i);
		}
	}
	static void print(int r[]) {
		System.out.print("[");
		for(int i:r) {
			System.out.print(i+",");
		}
		System.out.println("]");
	}
}
