package dsa.shaurya.tree;

public class DeleteTree {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		delete(root);
		
	}

	
	public static void delete(TreeNode root) {
		if(root!=null) {
			if(root.left!=null)
				delete(root.left);
			if(root.left!=null)
				delete(root.right);
			System.out.println("deleting "+root.data);
			root=null;
		}
	}
}
