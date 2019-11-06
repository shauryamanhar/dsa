package dsa.shaurya.tree;

public class Main {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		
//		t.preorderItr(root);
		System.out.println(t.sizeItr(root));
		
	}

}
