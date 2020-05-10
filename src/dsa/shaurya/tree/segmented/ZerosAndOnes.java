package dsa.shaurya.tree.segmented;
import java.util.*;

public class ZerosAndOnes{
	
	static int tree[] = new int[100000];
	
	static void build(int node,int st,int en) {
		if(st==en) {
			tree[node]=1;
		}else {
			int mid = (st+en)/2;
			build(2*node,st,mid);
			build(2*node+1,mid+1,en);
			tree[node]=tree[2*node]+tree[2*node+1];
		}
	}//build
	
	
	static void update(int node,int st,int en,int index) {
		if(st==index && en==index) {
			tree[node]=0;
		}else {
			int mid = (st+en)/2;
			if(index>=st && index<=mid) {
				update(2*node,st,mid,index);
			}else {
				update(2*node+1,mid+1,en,index);
			}
			tree[node]=tree[2*node]+tree[2*node+1];
		}
	}//update
	
	static int query(int node,int st,int en,int k,int n) {
		if(st<1 || en>n || tree[node]<k) {
			return -1;
		}
		if(st==en && k==1) {
			return st;
		}
		
		int val = tree[node];
		int mid = (st+en)/2;
		
		int leftNode = tree[2*node];
		int rightNode = tree[2*node+1];
		
		if(k>leftNode) {
			return query(2*node, st, mid, k-leftNode, n);
		}else {
			return query(2*node+1, mid+1, en, k-rightNode, n);
		}
		
	}//query
	
	public static void main(String[] args) {
		int n,k,q,type,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		build(1, 1, n-1);
		q= sc.nextInt();
		while(q-->0) {
			type=sc.nextInt();
			if(type==0) {
				i=sc.nextInt();
				update(0, 0, n-1, i);
			}else {
				k=sc.nextInt();
				System.out.println(query(1, 1, n-1, k, n));
			}
		}
	}
	
}//class