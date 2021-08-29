package dsa.shaurya.linkedlist;

public class Operations {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = null;
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next=null;
//		head = insertLast(head, 4);
//		head = insertLast(head, 5);
//		head = insertLast(head, 6);
//		head = insertLast(head, 7);
//		head = reverseSelf(head);
		head = reverseBetween(head,1,1);
		print(head);
	}
	
	static public Node reverseBetween(Node A, int B, int C) {
        
		Node head1 = A,curr=A;
		Node prev = null;
		int count=1;
		while(count<B && curr.next!=null) {
			prev = curr;
			curr = curr.next;
			count++;
		}
		if(prev!=null)
			prev.next=null;
		head1=curr;
		while(count<=C && curr.next!=null) {
			prev = curr;
			curr=curr.next;
			count++;
		}
		
		if(prev!=null)
			prev.next=null;
		Node head2 = curr;
		head1 = reverseSelf(head1);
		Node p = A;
		while(p.next!=null) {
			p = p.next;
		}
		 
		p.next = head1;
		
		while(p.next!=null) {
			p=p.next;
		}
		p.next = head2;
        return A;
    }
	
	public static Node reverseSelf(Node head) {
		Node temp=null,q=null;
		while(head!=null) {
			temp = head.next;//c
			head.next = q;
			q = head;
			head = temp;//c
		}
		return q;
	}
	
	public static Node reverse(Node curr) {
		Node prev =null,temp;
		while(curr!=null) {
			temp = curr.next;
			curr.next=prev;
			prev = curr;
			curr = temp;
		}
		return prev;
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
