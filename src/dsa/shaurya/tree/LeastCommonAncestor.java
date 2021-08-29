package dsa.shaurya.tree;

import java.util.ArrayList;

public class LeastCommonAncestor {
	static class Tree{
		int val;
		Tree left,right;
		Tree(int val){
			this.val=val;
			this.left=this.right=null;
		}
	}
	ArrayList<Tree> list1 = new ArrayList<LeastCommonAncestor.Tree>();
	ArrayList<Tree> list2 = new ArrayList<LeastCommonAncestor.Tree>();
	
	
	public static void main(String[] args) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
	}
	
	static void findLCA(Tree root,int a,int b) {
		
	}
	
}
