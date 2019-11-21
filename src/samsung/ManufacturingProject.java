package samsung;
import java.util.Scanner;
public class ManufacturingProject {

	int model[][] = new int[8][4];
	boolean visited[] = new boolean[8];
	int maxCost=0;
	
	int D;//total number of cpu available
	int E;//total number of memory available
	int F;//total number of board available
	int d;//cost of cpu
	int e;//cost of memory
	int N;//number of model
	
	void getMax(int c,int m,int b,int n,int cost) {
		int i,j;
		maxCost = Math.max(maxCost,(cost+c*d+m*e));
		if((n==4) || (c==0) || (m==0) || (b==0)) {
			return;
		}
		for(i=0;i<N;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				j=1;
				while(true) {
					if((j*model[i][0]<=c) && (j*model[i][1]<=m) && (j*model[i][2]<=b)) {
						getMax(c - j*model[i][0],m-j*model[i][1],b-j*model[i][2],n+1,cost+j*model[i][3]);
					}else {
						break;
					}
					j++;
				}//while
			}//if
			visited[i]=false;
		}//for
	}//getMax
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ManufacturingProject m = new ManufacturingProject();
		int t = scan.nextInt();
		while(t-->0) {
			m.D = scan.nextInt();
			m.E = scan.nextInt();
			m.F = scan.nextInt();
			m.d = scan.nextInt();
			m.e = scan.nextInt();
			//end line 1
			m.N = scan.nextInt();
			for(int i=0;i<m.N;i++) {
				m.model[i][0]=scan.nextInt();;
				m.model[i][1]=scan.nextInt();;
				m.model[i][2]=scan.nextInt();;
				m.model[i][3]=scan.nextInt();;
			}
			//end ip
			m.maxCost=0;
			m.getMax(m.D, m.E, m.F, 1, 0);
			System.out.println(m.maxCost);
		}//while

	}

}
