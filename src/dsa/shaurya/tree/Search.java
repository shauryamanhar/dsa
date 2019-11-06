package dsa.shaurya.tree;

import java.util.*;
public class Search {

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode root = new TreeNode(1);
		
		tree.insert(root, 4);
		tree.insert(root, 6);
		tree.insert(root, 9);
		tree.insert(root, 2);
		
		System.out.println(search(root,2));
//		tree.levelorder(root);
		
	}
	
	public static boolean searchItr(TreeNode root, int data) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.data==data) {
				return true;
			}else {
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
		}
		return false;
	}//search
	public static boolean search(TreeNode root, int data) {
		boolean temp;
		if(root==null) {
			return false;
		}else {
			if(data==root.data) {
				return true;
			}else {
				temp = search(root.left,data);
				if(temp!=false) {
					return temp;
				}else {
					return search(root.right, data);
				}
			}
		}
	}//search

}
