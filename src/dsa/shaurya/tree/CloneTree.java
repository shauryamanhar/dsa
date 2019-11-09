package dsa.shaurya.tree;

import java.util.HashMap;
import java.util.Stack;

public class CloneTree {
	private static class Node{
		int key;
		Node left,right,random;
		Node(int key){
			this.key = key;
			left=right=random=null;
		}
	}//class
	public static void main(String[] args) {
		Node tree = new Node(1); 
	    tree.left = new Node(2); 
	    tree.right = new Node(3); 
	    tree.left.left = new Node(4); 
	    tree.left.right = new Node(5); 
	    tree.random = tree.left.right; 
	    tree.left.left.random = tree; 
	    tree.left.right.random = tree.right;
	    preorder(tree);
	    Node newNode = clone(tree);
	    System.out.println();
	    preorder(newNode);
	}
	
	private static Node clone(Node treeNode) {
		if(treeNode==null) {
			return null;
		}
		HashMap<Node, Node> map = new HashMap<CloneTree.Node, CloneTree.Node>();
		Node newTree = cloneLeftRight(treeNode,map);
		return newTree;
	}

	private static Node cloneLeftRight(Node treeNode, HashMap<Node, Node> map) {
		if(treeNode==null) {
			return null;
		}
		Node clone = new Node(treeNode.key);
		map.put(treeNode, clone);
		clone.left = cloneLeftRight(treeNode.left, map);
		clone.right = cloneLeftRight(treeNode.right, map);
		copyRandom(treeNode,clone,map);
		return clone;
	}
	
	private static void copyRandom(Node treeNode, Node clone,HashMap<Node,Node> map) {
		if(clone==null) {
			return;
		}
		clone.random = map.get(treeNode.random);
		copyRandom(treeNode.left, clone.left, map);
		copyRandom(treeNode.right, clone.right, map);
	}
	
	
	private static  void preorder(Node root) {
		if(root!=null) {
			try {
				System.out.print("["+root.key+",");
				System.out.print(root.random==null? null+"]":root.random.key+"] ");
			} catch (Exception e) {
				System.out.print("ex");
			}
			preorder(root.left);
			preorder(root.right);
		}
	}

}
