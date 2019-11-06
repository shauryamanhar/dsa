package dsa.shaurya.tree;

import java.util.*;

public class ReverseLevelOrder {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		printReverseOrder(root);
		
	}
	
	public static void printReverseOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp ;
		while(!q.isEmpty()) {
			temp =q.poll();
			stack.push(temp);
			if(temp.right!=null) {
				q.add(temp.right);
			}
			if(temp.left!=null) {
				q.add(temp.left);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data+" ");
		}
	}

}
