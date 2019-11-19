package dsa.shaurya.graph;

import java.util.*;

public class TestClass {
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> adj[] = null;
    static boolean visited[] = null;
    public static void main(String args[] ) throws Exception {
       int n = sc.nextInt();
       int m = sc.nextInt();
       visited = new boolean[n+1];
       adj = new ArrayList[n+1];
       //init
       for(int i=0;i<=n;i++){
           adj[i]=new ArrayList<Integer>();
       }
       //a b in input
       for(int i=0;i<=n;i++){
    	   System.out.println("a");
           int a = sc.nextInt();
           System.out.println("b");
           int b = sc.nextInt();
           adj[a].add(b);
           adj[b].add(a);
       }
       boolean path = false;
       
       int q = sc.nextInt();
       
       for(int i=0;i<q;i++){
    	   System.out.println("a");
           int a = sc.nextInt();
           System.out.println("b");
           int b = sc.nextInt();
           System.out.println(adj[a].get(new Integer(b))==null?"N)":"YES");
          
       }
    }//main
}
