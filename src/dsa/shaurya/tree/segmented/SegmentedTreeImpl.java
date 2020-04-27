package dsa.shaurya.tree.segmented;

public class SegmentedTreeImpl {
	public static void main(String[] args) {
		int a[] = {1,2,3};
		int n = a.length;
		int size = 3*n;
		int tree[] = new int[size];
		build(0,0,a.length-1,a,tree);
		print(tree);
		System.out.println(query(0, 0, a.length-1, 0, 1, a, tree));
	}
	static void print(int a[]) {
		for(int r:a) {
			System.out.print(r+" ");
		}
		System.out.println();
	}
	static void build(int node,int start,int end,int a[],int tree[]) {
		if(start==end) {
			tree[node]=a[start];
		}else {
			int mid = (start+end)/2;
			build(2*node+1,start,mid,a,tree);
			build(2*node+2,mid+1,end,a,tree);
			tree[node]=tree[2*node+1]+tree[2*node+2];
		}
	}
	
	static void update(int node,int start,int end,int idx,int val,int a[],int tree[]){
		if(start==end) {
			a[idx]=val;
			tree[node]=val;
		}else {
			int mid = (start+end)/2;
			if(start<=mid && end<=mid) {
				//go left
				update(2*node+1,start,mid,idx,val,a,tree);
			}else {
				update(2*node+2,mid+1,end,idx,val,a,tree);
			}
			tree[node]=tree[2*node+1]+tree[2*node+2];
		}
	}//update
	
	static int query(int node,int start,int end,int l,int r,int a[],int tree[]) {
		if(r<start || l>end) {
			//range represented by a node is completely outside the given range
			return 0;
		}
		
		if(l<=start && r<=end) {
			// range represented by a node is completely inside the given range
			return tree[node];
		}
		// range represented by a node is partially inside and partially outside the given range
		int mid = (start+end)/2;
		int p1 = query(2*node+1, start, mid, l, r, a, tree);
		int p2 = query(2*node+2, mid+1, end, l, r, a, tree);
		return p1+p2;
	}
	
}