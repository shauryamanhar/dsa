package dsa.shaurya.tree;

public class rootToLeafPath {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		printRootToLeaf(root,new int[10],0);
	}
	
	private static void printRootToLeaf(TreeNode root,int []path,int pathLen) {
		if(root==null) {
			return;
		}
		path[pathLen]=root.data;
		pathLen++;
		if(root.left==null && root.right==null) {
			for(int i=0;i<pathLen;i++) {
				System.out.print(path[i]+" ");
			}
			System.out.println();
		}else {
			if(root.left!=null) {
				printRootToLeaf(root.left, path, pathLen);
			}
			if(root.right!=null) {
				printRootToLeaf(root.right, path, pathLen);
			}
		}
	}
}
