package dsa.shaurya.tree;

class Tree{
	int val;
	Tree left;
	Tree right;
	Tree(int val){
		this.val=val;
	}
}
public class LongestUnivalue {

	public static void main(String[] args) {
		Tree root = new Tree(5);
		root.right = new Tree(5);
		root.right.right = new Tree(5);
		
		root.left = new Tree(4);
		root.left.left = new Tree(1);
		root.left.right = new Tree(1);
		
		lg(root);
		
		
	}
	
	static int lg(Tree root) {
		if(root==null) {
			return 0;
		}
		System.out.println(root.val);
		int left = lg(root.left);
		int right =lg(root.right);
		System.out.println("left "+left);
		System.out.println("right "+right);
		return root.val;
	}

}
