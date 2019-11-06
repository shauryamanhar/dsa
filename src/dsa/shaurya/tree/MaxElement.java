package dsa.shaurya.tree;

import java.util.*;
public class MaxElement {

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode root = new TreeNode(1);
		tree.insert(root, 2);		
		tree.insert(root, 3);		
		tree.insert(root, 4);		
		tree.insert(root, 5);		
		tree.insert(root, 6);
		
		System.out.println(findMax(root));
		System.out.println(findMaxItr(root));
		

	}
	
	static int findMax(TreeNode root) {
		int left,right,rootValue,temp,max=Integer.MIN_VALUE;
		if(root!=null) {
			rootValue = root.data;
			left = findMax(root.left);
			right = findMax(root.right);
		
			temp = Math.max(left, right);
			max = Math.max(temp, rootValue);
			return max;
		}
		return max;
	}
	static int findMaxItr(TreeNode root) {
		int max = Integer.MIN_VALUE;
		TreeNode temp ;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.data>max) {
				max = temp.data;
			}
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
			
		}//while
		return max;
	}

}
