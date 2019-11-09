package dsa.shaurya.tree;

import java.util.Stack;

public class CloneTree {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		t.levelorder(clone(root));
		t.levelorder(root);
	}
	static TreeNode clone(TreeNode root1) {
		TreeNode newRoot = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp;
		newRoot = root1;
		temp = newRoot;
		stack.push(root1);
		while(!stack.isEmpty()) {
			root1 = stack.pop();
			temp = root1;
			if(root1.left!=null) {
				temp.left=root1.left;
				stack.push(root1.left);
			}
			if(root1.right!=null) {
				temp.right=root1.right;
				stack.push(root1.right);
			}
			
		}
		return newRoot;
	}

}
