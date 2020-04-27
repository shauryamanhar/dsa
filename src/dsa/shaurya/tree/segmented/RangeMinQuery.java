package dsa.shaurya.tree.segmented;

import java.util.Scanner;

public class RangeMinQuery {
	
	static int a[];
	static int tree[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		a = new int[n];
		tree = new int[4*n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		int l,r,node=0,start=0,end=n-1;
		//build tree
		build(node,start,end);
		//queries
		char c;
		for(int i=0;i<q;i++) {
			c = sc.next().charAt(0);
			l = sc.nextInt();
			r = sc.nextInt();
			
			switch (c) {
			case 'q':
				//query
				l--;
				r--;
				int result = query(node,start,end,l,r);
				System.out.println(result);
				break;
			case 'u':
				update(node,start,end,l-1,r);
				break;
			}
		}//for
		
		
	}//main
	private static void build(int node, int start, int end) {
		if(start==end) {
			tree[node]=a[start];
		}else {
			int mid = (start+end)/2;
			int left = 2*node+1;
			int right = left+1;
			build(left,start,mid);
			build(right,mid+1,end);
			
			tree[node] = Math.min(tree[left], tree[right]);
		}
		
	}
	private static void update(int node, int start, int end, int index, int val) {
		if(start==end) {
			//leaf node
			a[index]=val;
			tree[node]=val;
		}else {
			int mid = (start+end)/2;
			int left = 2*node+1;
			int right = left+1;
			if(index<=mid) {
				update(left,start,mid,index,val);
			}else {
				update(right,mid+1,end,index,val);
			}
			
			tree[node] = Math.min(tree[left],tree[right]);
		}
	}//update
	private static int query(int node, int start, int end, int l, int r) {
		//no overlapping
		if(l>end || r<start) {
			return Integer.MAX_VALUE;
		}
		
		//fully overlapping
		if(start>=l && end<=r) {
			return tree[node];
		}
		//partial overlapping
		int mid = (start+end)/2;
		int left = 2*node+1;
		int right = left+1;
		
		return Math.min(query(left,start,mid,l,r), query(right,mid+1,end,l,r));
	}
}
