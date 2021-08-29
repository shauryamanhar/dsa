package dsa.shaurya.general;
import java.util.*;
public class PrisonBreak {

	public static void main(String[] args) {
		int n=2;
		int m=2;
		int[] h= {1};
		int[] v= {1};
		List<Integer> hori = new ArrayList<Integer>();
		List<Integer> ver = new ArrayList<Integer>();
		for(int a:h) {
			hori.add(a);
		}
		for(int a:v) {
			ver.add(a);
		}
		System.out.println(prison(n, m, hori, ver));
	}
	
	static long prison(int n,int m, List<Integer> hori,List<Integer> ver) {
		boolean xs[] = new boolean[n+1];
		boolean ys[] = new boolean[m+1];
		for(int h:hori) xs[h]=true;
		for(int v:ver) ys[v]=true;
		long xm=0,ym=0;
		for(int i=1,j=0;i<=n;i++) {
			if(!xs[i]) j=0;
			else xm = Math.max(xm, ++j);
		}
		for(int i=1,j=0;i<=m;i++) {
			if(!ys[i]) j=0;
			else ym = Math.max(ym, ++j);
		}
		return (xm+1)*(ym+1);
	}

}
