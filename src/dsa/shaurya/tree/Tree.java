package dsa.shaurya.tree;

import java.util.*;

public class Tree {
	int size(TreeNode root) {
		int size=0;
		if(root!=null) {
			size = size(root.left)+size(root.right);
		}
		return size;
	}
	int sizeItr(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp;
		int size=0;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.left!=null) {
				q.add(temp.left);
				
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
			size++;
		}
		return size;
	}
	
	void preorder(TreeNode root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	void inorder(TreeNode root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	void postorder(TreeNode root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	void preorderItr(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true) {
			while(root!=null) {
				System.out.print(root.data+" ");
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
			System.out.print(root.data+" ");
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
	void levelorder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp ;
		q.add(null);
		int level =1;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp==null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				System.out.println("[level "+(level++)+"]");
			}else {
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
		}
	}
	
	
	
}//class
