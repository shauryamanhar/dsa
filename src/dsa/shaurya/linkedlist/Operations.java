package dsa.shaurya.linkedlist;

public class Operations {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next=null;
//		head = insertLast(head, 4);
		head = insertAt(head,4,7);
		head = removeFromEnd(head);
		head = removeFromEnd(head);
		print(head);
	
	}
	
	public static Node removeFromEnd(Node head) {
		Node p = head,q = null;
		if(head==null) {
			return null;
		}
		Node next = head.next;
		
		if(next==null) {
			head = null;
			System.out.println("Deleted:->"+p.data);
			return head;
		}
		while(next!=null) {
			q=p;
			p = next;
			next=next.next;
		}
		
		q.next = p.next;
		System.out.println("Deleted:->"+p.data);
		return head;
	}
	
	public static Node removeFromBegin(Node head) {
		Node curr = head;
		if(head!=null) {
			head = curr.next;
			curr.next = null;
			return head;
		}
		return head;
	}

	public static Node insertAt(Node head,int data,int position) {
		int k=1;
		Node curr = head;
		Node newNode = new Node(data);
		if(position<0) {
			position = 0;
		}
		int length = size(head);
		if(position > length) {
			position = length;
		}
		
		if(position==0) {
			newNode.next = head;
			head = newNode;
		}else {
			while(k<position && curr!=null) {
				curr = curr.next;
				k++;
			}
			
			newNode.next=curr.next;
			curr.next=newNode;
		}
		return head;
		
	}

	public static Node insertFirst(Node head,int data) {
		Node newNode = new Node(data);
		if(head==null) {
			newNode.next=head;
			head = newNode;
		}else {
			newNode.next=head;
			head=newNode;
		}
		return head;
	}
	
	public static Node insertLast(Node head,int data) {
		Node newNode = new Node(data);
		if(head==null) {
			newNode.next=head;
			head=newNode;
		}else {
			Node curr = head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=newNode;
			newNode.next=null;
			
		}
		return head;
	}
	
	public static void print(Node head) {
		Node curr = head;
		System.out.print("head");
		while(curr!=null) {
			System.out.print("->"+curr.data);
			curr=curr.next;
		}
		System.out.println();
	}
	
	public static int size(Node head) {
		Node curr= head;
		int size =0 ;
		while(curr!=null) {
			curr=curr.next;
			size++;
		}
		return size;
	}
	

}
