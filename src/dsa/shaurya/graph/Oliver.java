package dsa.shaurya.graph;

import java.util.*;

public class Oliver {
    static int TROOPS=0;
    static int MAX_soldier=0;
    static int soldier;
    static int[][] matrix = null;
    static boolean visited[][] = null;
    static int N;
    static int M;
    static int[] x_coord = {-1,1,0,0,-1,1,-1,1};
    static int[] y_coord = {0,0,-1,1,-1,1,1,-1};

    static boolean inRange(int x,int y){
        if(x>=0 && x<N && y>=0 && y<M){
             return true;
        }   
        else{
            return false;
        }
    }

    static void dfs(int x,int y){
        visited[x][y] = true;
        soldier++;
        for(int i=0;i<8;i++){          
            if(inRange(x+x_coord[i],y+y_coord[i]) && matrix[x+x_coord[i]][y+y_coord[i]] !=0 && visited[x+x_coord[i]][y+y_coord[i]]==false ){
                dfs(x+x_coord[i],y+y_coord[i]);
            }            
        }
    }

    public static void main(String args[] ) throws Exception {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int i=0;i<t;i++){
    	  N = scan.nextInt();
          M = scan.nextInt();
          visited = new boolean[N][M];
          matrix = new int[N][M];
             TROOPS = 0;
             MAX_soldier = 0;
             soldier = 0;
          for(int x=0;x<N;x++){
              for(int y=0;y<M;y++){
                  matrix[x][y] = scan.nextInt();
                  visited[x][y] = false;
              }
          }
          
          for(int x=0;x<N;x++){
              for(int y=0;y<M;y++){
                 if(matrix[x][y] == 1 && visited[x][y]==false){
                     TROOPS++;
                     soldier = 0;
                     bfs(x,y);
                 }
                 if(MAX_soldier<soldier){
                     MAX_soldier = soldier;
                 }
              }
          }

          System.out.println(TROOPS+" "+MAX_soldier);       
      }      

    }
    static void bfs(int x,int y) {
    	Queue<Pair> q = new LinkedList<Pair>();
    	q.add(new Pair(x,y));
    	visited[x][y]=true;
    	while(!q.isEmpty()) {
    		soldier++;
    		Pair p = q.poll();
    		x = p.x;
    		y = p.y;
    		for(int i=0;i<8;i++){          
                if(inRange(x+x_coord[i],y+y_coord[i]) && matrix[x+x_coord[i]][y+y_coord[i]] !=0 && visited[x+x_coord[i]][y+y_coord[i]]==false ){
                    q.add(new Pair(x+x_coord[i],y+y_coord[i]));
                    visited[x+x_coord[i]][y+y_coord[i]]=true;
                }            
            }
    	}
    }
    static class Pair{
    	int x,y;
    	Pair(int x,int y){
    		this.x=x;
    		this.y=y;
    	}
    }
}
