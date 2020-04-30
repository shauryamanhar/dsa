import java.util.Scanner;
public class Solution{
	static class PriorityTable {
		int count;
		int sumOfTime;
		boolean sorted;
		Node head;
		public PriorityTable() {
			this.count=0;
			this.sumOfTime=0;
			head=null;
		}
		class Node{
			String name;
			int et;
			Node next;
			Node(String name,int et){
				this.name=name;
				this.et=et;
				this.next=null;
			}
		}//Node

		void insert(String name,int et) {
			Node nn = new Node(name,et);
			nn.next = head;
			head=nn;
		}//insert

		//sorting

		void sort() {
			head = mergeSort(head);
		}
		
		Node sortedMerge(Node a, Node b){ 
			Node result = null; 
			/* Base cases */
			if (a == null) 
				return b; 
			if (b == null) 
				return a; 

			int com = a.name.compareTo(b.name);
			if(com>0) {
				result=b;
				result.next=sortedMerge(a, b.next);
			}else if(com<0) {
				result=a;
				result.next=sortedMerge(a.next, b);
			}else {
				if(a.et<=b.et) {
					result=a;
					result.next=sortedMerge(a.next, b);
				}else {
					result=b;
					result.next=sortedMerge(a, b.next);
				}
			}
			
			return result; 
		}//sorted

		Node mergeSort(Node h){ 
	        if (h == null || h.next == null) { 
	            return h; 
	        } 
	  
	        Node middle = getMiddle(h); 
	        Node nextofmiddle = middle.next; 
	  
	        middle.next = null; 
	  
	        Node left = mergeSort(h); 
	  
	        Node right = mergeSort(nextofmiddle); 
	  
	        Node sortedlist = sortedMerge(left, right); 
	        return sortedlist; 
	    }//mergeSort 
		
		

		public Node getMiddle(Node head){ 
			if (head == null) 
				return head; 
			Node slow = head, fast = head; 
			while (fast.next != null && fast.next.next != null) { 
				slow = slow.next; 
				fast = fast.next.next; 
			} 
			return slow; 
		} 
		
		public void print() {
			Node curr  = head;
			System.out.print("sumOfTime "+sumOfTime);
			while(curr!=null) {
				System.out.print(" {"+curr.name+","+curr.et+"}");
				curr=curr.next;
			}
			System.out.println(">>print end");
		}
		
	}//pt
	///////////////////////
	static PriorityTable table[];
	static int max;
	public static void init() {
		max=100;
		table = new PriorityTable[max];
	}
	
	public static void print() {
		for(int i=max-1;i>=0;i--) {
			if(table[i]!=null) {
				table[i].print();
			}
		}
	}
	
	public static void addPerson(String name,int pr,int et) {
		if(table[pr]==null) {
			table[pr]=new PriorityTable();
			table[pr].insert(name, et);
		}else{
			table[pr].insert(name, et);
		}
		table[pr].count++;
		table[pr].sumOfTime+=et;
		table[pr].sorted=false;
	}//add person
	
	public static int getResult(int time) {
		int count=0;
		for(int i=max-1;i>=0 && time>=0;i--) {
			if(table[i]==null) {
				continue; 
			}
			if(time-table[i].sumOfTime>=0) {
				count+=table[i].count;
				time=time-table[i].sumOfTime;
			}else {
				PriorityTable.Node curr = table[i].head;
				while(curr!=null) {
					if(time-curr.et<=0) {
						return count;
					}
					time=time-curr.et;
					count++;
				}
			}//if else
			
			
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int np = scan.nextInt();
		String name;
		int pr,et;
		init();
		for(int i=0;i<np;i++) {
			name = scan.next();
			pr = scan.nextInt();
			et = scan.nextInt();
			addPerson(name, pr, et);
		}
		
		print();
		int q =scan.nextInt();
		int time;
		for(int i=0;i<q;i++) {
			time=scan.nextInt();
			System.out.println((i+1)+"> ans "+getResult(time));
		}
	}
}