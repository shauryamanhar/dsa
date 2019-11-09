package dsa.shaurya.tree;

import java.util.*;
public class CountLeafNode {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
//		printAllLeafNode(root);
//		countAllLeafNode(root);
		System.out.println(countAllLeafNodeItr(root));
	}
	static void printAllLeafNode(TreeNode root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			System.out.print(root.data+" ");
		if(root.left!=null)
			printAllLeafNode(root.left);
		if(root.right!=null)
			printAllLeafNode(root.right);
	}
	
	static int countAllLeafNode(TreeNode root) {
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
			return 1;
		else {
			return countAllLeafNode(root.left) + countAllLeafNode(root.right);
		}
		
	}
	static int countAllLeafNodeItr(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp;
		int count=0;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.left==null && temp.right==null){
				count++;
			}
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		return count;
	}//count
}//class
