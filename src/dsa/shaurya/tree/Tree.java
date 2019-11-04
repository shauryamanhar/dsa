package dsa.shaurya.tree;

import java.util.*;

public class Tree {
	
	void preorder(TreeNode root) {
		if(root!=null) {
			System.out.println(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	void inorder(TreeNode root) {
		if(root!=null) {
			preorder(root.left);
			System.out.println(root.data+" ");
			preorder(root.right);
		}
	}
	void postorder(TreeNode root) {
		if(root!=null) {
			preorder(root.left);
			preorder(root.right);
			System.out.println(root.data+" ");
		}
	}
	void preorderItr(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true) {
			while(root!=null) {
				System.out.println(root.data+" ");
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.right;
		}
	}
	void inorderItr(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.println(root.data+" ");
			root = root.right;
		}
	}
	void postorderItr(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.right;
			System.out.println(root.data+" ");
		}
	}
	
	void insert(TreeNode root,int data) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp= null;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.left==null) {
				temp.left = new TreeNode(data);
				return;
			}else {
				q.add(temp.left);
			}
			if(temp.right==null) {
				temp.right = new TreeNode(data);
				return;
			}else {
				q.add(temp.right);
			}
		}
	}
	
	
	
}//class
