package dsa.shaurya.linkedlist;

public class CLLOperations {
	public static void main(String[] args) {
		CLLNode head = null;
		head = insertFront(head, 1);
		head = insertFront(head, 1);
		head = insertFront(head, 1);
		head = insertEnd(head, 2);
		head = insertEnd(head, 3);
		head = insertEnd(head, 4);
		head = insertFront(head, 5);
		head = insertFront(head, 9);
		head = insertEnd(head, 6);
		print(head);
//		System.out.println(deleteLast(head).data);
//		System.out.println(deleteLast(head).data);
		head = deleteBegin(head);
		print(head);
	}
	
	public static CLLNode deleteBegin(CLLNode head) {
		CLLNode curr = head;
		if(head==null) {
			return null;
		}else {
			while(curr.next!=head) {
				curr=curr.next;
			}
			curr.next=head.next;
			head = head.next;
		}
		return head;
	}
	
	public static CLLNode deleteLast(CLLNode head) {
		CLLNode curr = head,prev = null;
		
		if(head==null) {
			return null;
		}else {
			while(curr.next!=head) {
				prev = curr;
				curr = curr.next;
			}
			if(prev!=null)
				prev.next=curr.next;
		}
		
		
		return curr;
	}
	
	public static CLLNode insertFront(CLLNode head,int data) {
		CLLNode newNode = new CLLNode(data);
		CLLNode curr = head;
		newNode.next=newNode;//self
		
		if(head==null) {
			head=newNode;
			return head;
		}else {
			while(curr.next!=head) {
				curr=curr.next;
			}
			newNode.next=head;
			curr.next=newNode;
			head = newNode;
			return head;
		}
	}
	
	public static CLLNode insertEnd(CLLNode head,int data) {
		CLLNode newNode = new CLLNode(data);
		CLLNode curr = head;
		
		newNode.next=newNode;//self
		
		if(head==null) {
			head=newNode;
		}else {
			while(curr.next!=head) {
				curr=curr.next;
			}
			newNode.next=head;
			curr.next=newNode;
		}
		return head;
	}
	
	public static void print(CLLNode head) {
		CLLNode curr = head;
		System.out.print("head");
		do {
			System.out.print("->"+curr.data);
			curr = curr.next;
		}while(curr!=head);
		System.out.println("->null");
	}//print

}
