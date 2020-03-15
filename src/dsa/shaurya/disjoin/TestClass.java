package dsa.shaurya.disjoin;

import java.util.*;

public  class TestClass {
	static int n,m;
	static int a[];
	static int s[];
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n+1];
        s = new int[n+1];
        for(int i=1;i<=n;i++) {
        	a[i]=i;
        	s[i]=1;
        }
        
        int x,y;
        for(int i=0;i<m;i++) {
        	x = scan.nextInt();
        	y = scan.nextInt();
        	un(x,y);
        }
        
        for(int i=1;i<=n;i++) {
        	System.out.print(s[root(i)]-1+" ");
        }
        System.out.println();
        
    }
    
    static int root(int x) {
    	int p = x;
    	while(a[p]!=p) {
    		p = a[p];
    	}
    	return p;
    }
    
    static void un(int x,int y) {
    	int i = root(x);
    	int j = root(y);
    	if(i==j) {
    		return;
    	}
    	if (s[i] > s[j]) {
    		a[j] = i;
    		s[i] = s[i] + s[j];
    	} else {
    		a[i] = j;
    		s[j] = s[j] + s[i];
    	}
    }
    
    

}
