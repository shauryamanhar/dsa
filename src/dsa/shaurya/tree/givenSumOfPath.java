package dsa.shaurya.tree;

public class givenSumOfPath {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(1);
		t.insert(root, 2);
		t.insert(root, 3);
		t.insert(root, 4);
		t.insert(root, 5);
		t.insert(root, 6);
		t.insert(root, 7);
		
		System.out.println(hasPathSum(root, 3));
	}
	
	static private boolean hasPathSum(TreeNode root,int sum) {
		if(root==null) {
			return sum==0;
		}else {
			int restsum = sum - root.data;
			if((root.left!=null && root.right!=null) || (root.left==null && root.right==null)) {
				return (hasPathSum(root.left, restsum)||hasPathSum(root.right, restsum));
			}else if(root.left!=null) {
				return hasPathSum(root.left, restsum);
			}else {
				return hasPathSum(root.right, restsum);
			}
		}
		
	}

}
