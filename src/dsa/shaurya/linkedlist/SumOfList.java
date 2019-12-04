package dsa.shaurya.linkedlist;

public class SumOfList {

	
	
	static void sum(Node a,Node b) {
		Node ansList = null;
		int carry =0,sum,ans;
		Node head=null;
		while(a!=null && b!=null) {
			sum = a.data+b.data;
			carry=sum/10;
			ans = sum%10;
			if(ansList==null) {
				ansList = new Node(ans);
				head = ansList;
			}else{
				ansList.next = new Node(ans);
				ansList = ansList.next;
			}
			a = a.next;
			b = b.next;
		}//while
		
		print(head);
	}//sum
	
	static void print(Node node) {
		if(node==null) {
			return;
		}
		
		print(node.next);
		System.out.print(node.data+" ");
		
	}
	
	public static void main(String[] args) {
		Node a = new Node(3);
		a.next = new Node(2);
		a.next.next = new Node(1);
		Node b = new Node(3);
		b.next = new Node(2);
		b.next.next = new Node(1);
		
		sum(a,b);

	}

}
