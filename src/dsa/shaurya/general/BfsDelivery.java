package dsa.shaurya.general;

import java.util.*;

public class BfsDelivery {
    public static void main(String[] args) {
        // int a[][] = {{1,1,0},{1,9,0},{1,0,0}};
        int a[][] = {
            {1, 1, 1, 1},
            {1, 0 ,0 ,1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
            }; 
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<a[0].length;j++){
                l.add(a[i][j]);
            }
            list.add(l);
        }
        System.out.println(list);
        System.out.println(bfs(list));
    }   
    static int bfs(List<List<Integer>> list){
        int row=list.size();
        int col=list.get(0).size();
        int grid[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=list.get(i).get(j);
            }
        }

        boolean vis[][] = new boolean[row][col];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0,0));
        boolean found=false;
        vis[0][0]=true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int dis=p.dis;
            // System.out.println("x "+x+" y "+y + " dis  "+dis +" grid "+grid[x][y]);
            if(grid[x][y]==9){
                found=true;
                return dis;
            }
            //go right
            if(isSafe(grid, x, y+1) && !vis[x][y+1]){ 
                q.add(new Pair(x,y+1,dis+1));
                vis[x][y+1]=true;
            }
            //go left
            if(isSafe(grid, x, y-1) && !vis[x][y-1]){ 
                q.add(new Pair(x,y-1,dis+1));
                vis[x][y-1]=true;
            } 
            //go down
            if(isSafe(grid, x+1, y) && !vis[x+1][y]){ 
                q.add(new Pair(x+1,y,dis+1));
                vis[x+1][y]=true;
            } 
            //go top
            if(isSafe(grid, x-1, y) && vis[x-1][y]==false){ 
                q.add(new Pair(x-1,y,dis+1));
                vis[x-1][y]=true;
            }
        }
        return found==false?-1:0;
    }
    static boolean isSafe(int grid[][],int x,int y) {
        if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!=0){
            return true;
        }
        return false;
    }
    static class Pair{
        int x;int y;
        int dis;
        Pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
}
