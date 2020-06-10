package dsa.shaurya.binarysearch;

public class SearchMinInRotatedArray {

	public static void main(String[] args) {
		int a[] = {6,7,9,15,19,2,3};
		searchMin(a);
	}
	
	static void searchMin(int a[]) {
		int l=0,r=a.length-1;
		int mid = l+(r-l)/2;
		while(l<=r) {
			mid = l+(r-l)/2;
			if(a[l]>a[r]) {
				l = mid+1;
			}else {
				r = mid-1;
			}
		}
		System.out.println("a[l] "+a[l]);
	}

}
