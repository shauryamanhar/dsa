package dsa.shaurya.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	
	static void bfs(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			root = q.poll();
			if(root==null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				System.out.println();
			}else {
				System.out.print(root.data+" ");
				if(root.left!=null) {
					q.add(root.left);
				}
				if(root.right!=null) {
					q.add(root.right);
				}
			}
		}
	}//bfs
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		bfs(root);
	}
	
	
}
