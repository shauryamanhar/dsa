package dsa.shaurya.binarysearch;

public class FirstValueGreaterThanX {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,6,7,8,12};
		int x = 5;
		findGreaterThan(a, x);
	}
	
	static void findGreaterThan(int a[],int x) {
		int l=0,r=a.length-1;
		int mid = l+(r-l)/2;
		int ans=-1;
		while(l<=r) {
			mid = l+(r-l)/2;
			//if answer exists then there may be better answer then look for that
			if(a[mid]>=x) {
				ans=a[mid];
				r = mid-1;
			}else {
				l=mid+1;
			}
		}
		System.out.println("ans "+ans);
	}

}
