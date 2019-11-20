package dsa.shaurya.disjoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumSpanningTree {

	public class Pair implements Comparable<Pair>{
		int x,y,weight;
		Pair(int x,int y,int wt){
			this.x=x;
			this.y=y;
			this.weight=wt;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.weight==o.weight) {
				return 0;
			}else if(this.weight>o.weight) {
				return 1;
			}
			return -1;
		}
		@Override
		public String toString() {
			return "["+(x+1)+" "+(y+1)+" "+" "+weight+"]";
		}
	}//class
	
	MinimumSpanningTree(int node,int edge){
		this.node=node;
		this.edge=edge;
		this.list = new ArrayList<Pair>();
		parent = new int[node];
		for(int i=0;i<node;i++) {
			parent[i]=i;
		}
	}
	
	ArrayList<Pair> list;
	int parent[] = null;
	int node,edge;
	int root(int a) {
		while(a!=parent[a]) {
			a=parent[parent[a]];
		}
		return a;
	}//root
	
	
	boolean union(int a,int b) {
		int ra = root(a);
		int rb = root(b);
		if(ra==rb) {
			return false;
		}
		parent[ra]=rb;
		return true;
	}//union
	
	int kruskal() {
		int cost,minCost=0;
		Collections.sort(list);
		for(Pair pair:list) {
			int x =  pair.x;
			int y = pair.y;
			cost = pair.weight;
			if(root(x)!=root(y)) {
				minCost+=cost;
				union(x,y);
			}
		}
		return minCost;
	}//kruskal
	
	void add(int x,int y,int weight) {
		list.add(new Pair(x,y,weight));
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x,y,weight,node,edge;
		node = scan.nextInt();
		edge = scan.nextInt();
		MinimumSpanningTree t = new MinimumSpanningTree(node, edge);
		for(int i=0;i<edge;i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			weight = scan.nextInt();
			t.add(x-1, y-1, weight);
		}
		System.out.println(t.kruskal());
	}

}

/*
 
 5 7
1 2 1
1 3 7
2 3 5
2 4 4
2 5 3
3 5 6
4 5 2
 
 */
