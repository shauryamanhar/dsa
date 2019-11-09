package dsa.shaurya.tree;

public class StructurallyIdentical {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		
		TreeNode root2 = new TreeNode(1);
		t.insert(root2, 2);
		t.insert(root2, 3);
		t.insert(root2, 4);
		t.insert(root2, 5);
		t.insert(root2, 6);
		t.insert(root2, 7);
		
		System.out.println(equal(root,root2));

	}
	
	static boolean equal(TreeNode root1,TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		
		return root1.data==root2.data && equal(root1.left,root2.left)&& equal(root1.right,root2.right);
	}

}
