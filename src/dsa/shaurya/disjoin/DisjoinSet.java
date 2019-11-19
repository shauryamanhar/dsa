package dsa.shaurya.disjoin;

import java.util.Arrays;

public class DisjoinSet {

	
	
	public static void main(String[] args) {
		int n=5;
		DisjoinedSetRootApproach dsu = new DisjoinedSetRootApproach(n);
		dsu.wunion(1, 2);
		dsu.wunion(3, 4);
		dsu.wunion(4, 5);
		for(int i:dsu.size) {
			System.out.println(i);
		}
		dsu.wunion(1, 5);
	}//main

}
