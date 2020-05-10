package dsa.shaurya.tree.segmented;

import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
@SuppressWarnings("unused")
public class coding {
    int[][] val;int[] par;
    public static void main(String[] args) throws IOException  {
        new coding().solve();
    }
    
    void print(int a[],String name) {
		System.out.print(">>print "+name+">>");
		for(int r:a) {
			
			System.out.print(r+" ");
		}
		System.out.println(" >>print end");
	}
 
    public void solve() {
        int n=sc.nextInt();
        int q=sc.nextInt();
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
 
        // Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) ;
        int[] a=new int[n];
        Arrays.fill(a,1);
        int[] tree=new int[max_size];
        buildseg(a,tree,0,n-1,1);
        print(tree,"tree");
        while(q--!=0){
            int a1=sc.nextInt();
            int b2=sc.nextInt();
 
            if(a1==0){
                update(a,tree,b2-1,0,0,n-1,1);
                print(tree,"tree");
            }
            else{
                int r=query(a,tree,b2,0,n-1,1);
                if(tree[1]<b2)
                    System.out.println(-1);
                else
                    System.out.println(r+1);
            }
        }
 
 
 
 
 
    }
 
     void buildseg(int[] a,int[] tree,int l,int r,int i){
        if (l==r){
            if(a[l]==1)
                tree[i]=1;
        }
        else{
            int mid=(l+r)/2;
            buildseg(a,tree,l,mid,2*i);
            buildseg(a,tree,mid+1,r,2*i+1);
            tree[i]=tree[2*i]+tree[2*i+1];
        }
 
 
     }
     int query(int[] a,int[] tree,int in,int l,int r,int i){
        if (tree[i]<in||in<=0){
        	System.out.println("return 0");
            return 0;
        }
        else if(l==r) {
        	System.out.println("start == end");
            if(tree[i]==in&&tree[i]==1) {
            	System.out.println("return stat");
            	return l;
            }
            System.out.println("return 2 0");
            return 0;
        }
        int mid=(l+r)/2;
        return (query(a,tree,in,l,mid,2*i)+query(a,tree,in-tree[2*i],mid+1,r,2*i+1));
 
     }
 
 
     void update(int[] a,int[] tree,int p,int val,int l,int r,int i){
        if(l==r&&l==p){
            if(a[p]==1)
            tree[i]--;
            a[p]=0;
 
        }
        else {
            int mid=(l+r)/2;
            if(p<=mid)
                update(a,tree,p,val,l,mid,2*i);
            else
                update(a,tree,p,val,mid+1,r,2*i+1);
            tree[i]=tree[2*i]+tree[2*i+1];
        }
     }
 
 
    FastReader sc=new FastReader();
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}
class Node{
    Node x;int color;Node y;Node par;
 
    public Node(Node a,Node b,int c,Node p) {
        x=a;y=b;color=c;par=p;
 
    }
}
class order implements Comparator<Double>{
    public int compare(Double a,Double b){
        if(a>b)
            return -1;
        else if(a==b)
            return 0;
        else
            return 1;
    }
}
class P{
    int x;int y;
    public P(int a,int b){
        x=a;y=b;
    }
}
class Children{
    Children[] cc;
    public Children(){
        cc=new Children[26];
    }
}