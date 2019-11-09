package dsa.shaurya.tree;

public class convertMirror {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		convertToMirrorTree(root);
		
	}
	
	private static TreeNode convertToMirrorTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		convertToMirrorTree(root.left);
		convertToMirrorTree(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
	
	private static boolean checkMirrorTree(TreeNode root1,TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		if(root1.data == root2.data) {
			return true;
		}else {
			return checkMirrorTree(root1.left, root2.right) && checkMirrorTree(root1.right, root2.left);
		}
	}
	
}
