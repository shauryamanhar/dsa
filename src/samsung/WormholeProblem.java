package samsung;

import java.util.Scanner;

public class WormholeProblem {
	static class Hole{
		int x,y,a,b,w;
	}
	
	static int mat[][] = new int[100][100];
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			int sx,sy,dx,dy,n;
			sx = scan.nextInt();
			sy = scan.nextInt();
			dx = scan.nextInt();
			dy = scan.nextInt();
			n = scan.nextInt();
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					mat[i][j] = Math.abs(sx-i)+Math.abs(sy-j);
				}//for
			}//for
			mat[sx][sy] = 0;//source 0
			
			Hole hole[] = new Hole[2*n];
			int x,y,a,b,w;
			for(int i=0;i<2*n;i++) {
				x = scan.nextInt();
				y = scan.nextInt();
				a = scan.nextInt();
				b = scan.nextInt();
				w = scan.nextInt();
				
				
				//a->b
				hole[i].x=x;
				hole[i].y=y;
				hole[i].a=a;
				hole[i].b=b;
				hole[i].w=w;
				
				
				//b->a
				hole[i+1].a=x;
				hole[i+1].b=y;
				hole[i+1].x=a;
				hole[i+1].y=b;
				hole[i+1].w=w;
			}//holes
			
			
			boolean check = true;
			
			while(check) {
				check=false;
				for(int i=0;i<2*n;i++) {
					for(int j=0;j<2*n;j++) {
						if(i==j) {
							continue;
						}
						
						if(mat[hole[j].x][hole[j].y]+hole[j].w 
								+Math.abs(hole[j].x-hole[j].y)
								+Math.abs(hole[j].y-hole[j].b) <mat[hole[i].x][hole[i].y]   ) {
							
							mat[hole[i].x][hole[i].y] = mat[hole[j].x][hole[j].y] 
									+ Math.abs(hole[j].x-hole[j].a) 
									+ Math.abs(hole[j].y-hole[j].b);
							check = true;
						}//if
					}//for
				}//for
				
			}//while check
			int ans = Math.abs(sx-dx)+Math.abs(sy-dy);
			
			for(int i=0;i<2*n;i++) {
				if(mat[hole[i].x][hole[i].y]+Math.abs(hole[i].x-dx)+Math.abs(hole[i].y-dy)<ans) {
					ans = mat[hole[i].x][hole[i].y]+Math.abs(hole[i].x-dx)+Math.abs(hole[i].y-dy); 
				}
			}
			System.out.println(ans);
		}//while	
	}//main
	
}
