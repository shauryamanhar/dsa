package samsung;

import java.util.*;

public class TollGateProblem {

	public static void main(String[] args) {
		TollGateProblem t = new TollGateProblem();
		t.solve();
	}
	
	
	//toll pay
	int N; //total number of toll
	int tc[]; // toll cost
	int th[]; ///toll hire men
	int min_cost = Integer.MAX_VALUE; //min cost
	void solve() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			N = scan.nextInt();
			tc = new int[N];
			th = new int[N];
			for(int i=0;i<N;i++) {
				th[i] = scan.nextInt();
				tc[i] = scan.nextInt();
			}
			dfs(0,0,0,0,0);
			System.out.println(min_cost);
		}
	}
	//merge all
	void dfs(int tp,int bp3,int bp2,int bp1,int cc) {
		int tot_th = bp3+bp2+bp1;
		if(cc>min_cost) {//avoid unnecessary cpu cycle
			return;
		}
		if(tp==N-1) {
			if(tot_th<th[tp]) {
				cc+=tc[tp];
			}
			if(cc<min_cost) {
				min_cost = cc;
			}
			return;
		}//if
		dfs(tp+1,bp3,bp2,bp1,cc+tc[tp]);//pay the toll
		dfs(tp+1,bp3+th[tp],bp2,bp1,cc+2*tc[tp]);//hire and pay double
		
		if(th[tp]<=tot_th) {
			if(th[tp]>(bp2+bp1)) {
				bp3 = tot_th-th[tp]; 
				bp2=0;
				bp1=0;
			}else if(th[tp]>bp1) {
				bp2 = bp2+bp1-th[tp];
				bp1=0;
			}
			dfs(tp+1,0,bp3,bp2,cc);
		}//if
	}//dfs
	

}

/*
	void dfs(int tp,int cc) {
		if(tp==N-1) {//end of toll gate
			cc +=tc[tp];
			if(cc<min_cost) {
				min_cost=cc;
			}
			return;
		}//if
		
		dfs(tp+1,cc+tc[tp]);//pay the toll
	}//dfs
	
	//hire all men and pay double;
	void dfs(int tp,int bp3,int bp2,int bp1,int cc) {
		if(tp==N-1) {//end of toll gate
				cc +=tc[tp];
				if(cc<min_cost) {
					min_cost=cc;
				}
				return;
		}
		dfs(tp+1,bp3+th[tp],bp2,bp1,cc+2*tc[tp]);//hire and pay double
	}//dfs
	
	//battle and pay nothing
	void dfs(int tp,int bp3,int bp2,int bp1,int cc) {
		int tot_th = bp3+bp2+bp1;
		if(tp==N-1) {//end of toll gate
			if(tot_th<th[tp]) {
				cc+=tc[tp];
			}
			if(cc<min_cost) {
				min_cost=cc;
			}
			return;
		}//if
		
		//battle option
		if(th[tp]<=tot_th) {
			if(th[tp]<bp2+bp1) {
				bp3 = th[tp]-bp2-bp1;
			}
			bp2 = 0 ;
			bp1 = 0;
		}else if(th[tp]>bp1) {
			bp2 = (bp2+bp1)-th[tp];
			bp1=0;
		}
		dfs(tp+1,0,bp3,bp2,cc);
	}//dfs
 */