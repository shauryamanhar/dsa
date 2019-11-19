package dsa.shaurya.graph;
import java.util.*;
public class Graph {
	static ArrayList<Integer> adj[] = null;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int v = scan.nextInt();
		int e = scan.nextInt();
		adj = new ArrayList[v+1];
		for(int i=0;i<v+1;i++) {
			adj[i]=new ArrayList<Integer>();
		}
		int a,b;
		for(int i=0;i<e;i++) {
			a=scan.nextInt();
			b=scan.nextInt();
			adj[a-1].add(b);
			adj[b-1].add(a);
		}
		
		System.out.println(adj[0]);
		System.out.println(adj[1]);
		System.out.println(adj[2]);
		System.out.println(adj[3]);
		
//		System.out.println();
//		for(ArrayList<Integer> list:adj) {
//			for(int r:list) {
//				System.out.print(r+1+"->");
//			}
//			System.out.println();
//		}
		
		
//		int q = scan.nextInt();
//		for(int i=0;i<q;i++) {
//			a=scan.nextInt()-1;
//			b=scan.nextInt()-1;
//			if(adj[a].get(new Integer(b))==null) {
//				System.out.println("NO");
//			}else {
//				System.out.println("YES");
//			}
//		}
		
		
	}
}
