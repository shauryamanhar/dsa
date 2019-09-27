package dsa.shaurya.recusion;

public class SumOfArray {

	public static void main(String[] args) {
		int a[] = {1,2};
		System.out.println(sum(a,a.length-1));

	}
	
	static int sum(int a[],int n) {
		if(n==0) {
			return a[n];
		}
		return a[n]+sum(a,n-1);
	}

}
