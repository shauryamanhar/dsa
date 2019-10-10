package dsa.shaurya.linkedlist;

public class DllOperations {
	public static void main(String[] args) {
		DLLNode head = null;
		head = insert(head,1,1);
		head = insert(head,2,2);
		head = insert(head,3,3);
		head = insert(head,4,4);
		head = insert(head,5,5);
		
		head = reverse(head);
		print(head);
	}
	
	
	public static DLLNode reverse(DLLNode head) {
		DLLNode prev = null,temp = null,curr = head;
		while(curr!=null) {
			temp = curr.next;
			curr.next = prev;
			curr.prev = temp;
			prev = curr;
			curr = temp;
		}
		return prev;
				
	}
	
	public static DLLNode delete(DLLNode head,int position) {
		int k=1;
		DLLNode temp = null;
		if(position==1) {
			if(head!=null) {
				temp = head.next;
				head.next = temp;
				head.prev=null;
			}
			if(temp!=null)
				temp.prev=null;
			head = temp;
			return head;
					
		}else {
			temp = head;
			while(k<position && temp.next!=null) {
				temp=temp.next;
				k++;
			}
			
			
			temp.prev.next=temp.next;
			if(temp.next!=null)
				temp.next.prev=temp.prev;
			temp.prev=null;
			temp.next=null;
			return head;
			
		}
	}
	
	public static DLLNode insert(DLLNode head, int data,int position) {
		DLLNode temp,newNode = new DLLNode(data);
		int k=1;
		if(position==1) {
			newNode.next = head;
			newNode.prev = null;
			if(head!=null) {
				head.prev=newNode;
			}
			head = newNode;
			return head;
		}else {
			temp = head;
			while(k<(position-1) && temp.next!=null) {
				temp = temp.next;
				k++;
			}
			
			newNode.next = temp.next;
			newNode.prev = temp;
			if(temp.next!=null) {
				temp.next.prev = newNode;
			}
			temp.next=newNode;
			return head;
		}
		
	}//insert
	
	public static void print(DLLNode head) {
		DLLNode temp = head;
		System.out.print("head");
		while(temp!=null) {
			System.out.print("->"+temp.data);
			temp = temp.next;
		}
		System.out.println("->null");
	}//print
	

}
