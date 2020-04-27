import java.util.*;
public class April20CircutHackerEarthQ2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Long a[] = new Long[n];
		Long h[] = new Long[m];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextLong();
		}
		for(int i=0;i<m;i++) {
			h[i] = sc.nextLong();
		}

		Long q = sc.nextLong();
		int l,r;
		for(Long i=0L;i<q;i++) {
			l=sc.nextInt()-1;
			r=sc.nextInt()-1;
			happy(a, n, h, m, l, r);
		}

	}//main

	static void happy(Long a[],int n,Long h[],int m,int l,int r) {
		boolean flag = false;
		for(int i=0;i<m;i++) {
			Long count=0L;
			for(int j=l;j<=r;j++) {
				if(h[i]==a[j]) {	
					count++;
				}
			}
			if(count==0) {
				continue;
			}
			if(h[i]!=count) {
				System.out.println(0);
				return;
			}
//			System.out.printf("h[%d] %d, count %d\n",i,h[i],count);
		}
		System.out.println(1);
	}//happy


}

