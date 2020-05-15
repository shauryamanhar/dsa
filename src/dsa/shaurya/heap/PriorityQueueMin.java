package dsa.shaurya.heap;

public class PriorityQueueMin {
	int a[];
	int capacity;
	int count;
	public PriorityQueueMin(int capacity) {
		this.capacity=capacity;
		this.count=0;
		this.a=new int[capacity];
	}
	void heapify(int i) {
		int left=2*i+1,right=left+1;
		int min = i,temp;
		if(left>=0 && left<count && a[left]<a[min] ) {
			min=left;
		}
		if(right>=0 && right<count && a[right]<a[min]) {
			min=right;
		}
		if(min!=i) {
			temp = a[min];
			a[min]=a[i];
			a[i]=temp;
			heapify(min);
		}
	}//heapify
	
	void insert(int data) {
		if(count==capacity) {
			System.out.println("Overflow");
			return;
		}
		
		count++;
		int index = count-1;
		while(index>0 && data<a[(index-1)/2]) {
			a[index]=a[(index-1)/2];
			index = (index-1)/2;
		}
		a[index]=data;
	}
	
	int delete() {
		if(count==0) {
			return -1;
		}
		int temp = a[0];
		a[0]=a[count-1];
		a[count-1]=0;
		count--;
		heapify(0);
		return temp;
	}
	
	int getMin() {
		if(count==0) {
			return -1;
		}
		
		return a[0];
	}
	
	boolean isEmpty() {
		return count==0?true:false;
	}
	
	public static void main(String[] args) {
		PriorityQueueMin p = new PriorityQueueMin(10);
		p.insert(5);
		p.insert(2);
		p.insert(6);
		System.out.println(p.getMin());
	}
}