package dsa.shaurya.linkedlist;

public class Example {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node temp = head;
		for(int i=0;i<10;i++) {
			temp.setNext(new Node(i*10));
			System.out.println("temp "+temp.getData());
			temp = temp.getNext();
		}
		temp.setNext(null);
		temp = head;
		while(temp!=null) {
			System.out.println(temp.getData());
			temp=temp.getNext();
		}
	}
}
