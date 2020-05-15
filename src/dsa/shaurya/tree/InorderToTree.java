package dsa.shaurya.tree;

import java.util.LinkedList;
import java.util.Queue;
//inorder to build tree
public class InorderToTree {
	static class Node{
		int data;
		Node l,r;
		Node(int d){
			this.data=d;
			l=r=null;
		}
	}
	static Node root=null;
	
	public static void main(String[] args) {
		int in[]= {4,2,5,1,6,3,7};
//		int in[]= {2,1,3};
		root = buildTree(in, 0, in.length-1,root);
		inorder(root);
	}
	static void print(Node root) {
		if(root==null)
			return;
		System.out.println(root.data);
		print(root.l);
		print(root.r);
	}
	
	static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static Node buildTree(int in[],int l,int r,Node root) {
		//breaking coding
		if(l>r) {
			return null;
		}
		//coding for (0,0) (2,2) (4,4) (6,6)
		if(l==r) {
			return new Node(in[l]);
		}
		int mid = l+(r-l)/2;//mid for left and right tree
		root = new Node(in[mid]);
		root.l=buildTree(in, l, mid-1,root.l);
		root.r=buildTree(in, mid+1, r,root.r);
		return root;//return head of tree
	}
	static void inorder(Node root) {
		Queue<Node> q = new LinkedList<InorderToTree.Node>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			root = q.poll();
			if(root==null) {
				if(!q.isEmpty())
					q.add(null);
				System.out.println();
			}else {
				System.out.print(root.data+" ");
				if(root.l!=null)
					q.add(root.l);
				if(root.r!=null)
					q.add(root.r);
			}
		}
	}
}
