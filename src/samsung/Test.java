package samsung;

import java.util.*;

public class Test {
    static ArrayList<Integer> adj[] = null;
    static boolean visited[] = null;
    static int level[] = null;
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[] ) throws Exception {
    	int n = scan.nextInt();
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        level = new int[n+1];
        
        for(int i=0;i<=n;i++){
            adj[i]= new ArrayList<Integer>();
        }
        int x,y;
        //input n-1
        for(int i=0;i<n-1;i++){
            x = scan.nextInt();
            y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        
        int q = scan.nextInt();
         for(int i=1;i<n;i++){
             if(visited[i]==false){
                bfs(1);
             }
         }
        
         System.out.println("LEVEL PRINT ");
         for(int i:level) {
        	 System.out.print(i+" ");
         }
         System.out.println("+++++++");
        System.out.println(level[q]);
    }
    
    static void bfs(int s){
    	java.util.Queue<Integer> q = new LinkedList<Integer>();
    	
        q.add(s);
        level[s]=0;
        while(!q.isEmpty()){
            int p = q.poll();
            System.out.println("P "+p);
            for(int i:adj[p]){
            	if(i==0) {
            		continue;
            	}else {
            		if(visited[i]==false){
            			q.add(i);
            			visited[i]=true;
            			level[i] = level[p]+1;
            		}
            	}
            }
        }//while
    }
    
    
}
