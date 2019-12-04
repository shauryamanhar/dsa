package dsa.shaurya.linkedlist;

public class PalindromeCheck {

	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = next;
		}//node
	}//class
	
	Node reverse(Node node) {
		Node newHead = null;
		while(node!=null) {
			Node newNode = new Node(node.data);
			newNode.next = newHead;
			newHead = newNode;
			node = node.next;
		}
		return newHead;
	}
	
	boolean isPalindrome(Node node) {
		Node headRerversed = reverse(node);
		boolean isPalindrome = false;
		
		
		while(node!=null && headRerversed!=null) {
			if(node.data!=headRerversed.data) {
				return false;
			}
			node = node.next;
			headRerversed = headRerversed.next;
		}//while
		return true;
	}
	
	void solve() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		System.out.println(isPalindrome(head));
	}
	public static void main(String[] args) {
		PalindromeCheck p = new PalindromeCheck();
		p.solve();
	}

}
