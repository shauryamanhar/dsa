package dsa.shaurya.tree;

import java.util.*;

public class HeightOfTree {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		System.out.println(height(root));

	}
	public static int heightItr(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int level=0;
		while(!q.isEmpty()) {
			root = q.poll();
			if(root==null) {
				//new level
				level++;
				if(!q.isEmpty()) {
					q.add(null);
				}
			}else {
				if(root.left!=null)
					q.add(root.left);
				if(root.right!=null)
					q.add(root.right);
			}
		}
		return level;
	}
	
	public static int height(TreeNode root) {
		if(root==null)
			return -1;
		return Math.max(height(root.left), height(root.right))+1;
	}

}
