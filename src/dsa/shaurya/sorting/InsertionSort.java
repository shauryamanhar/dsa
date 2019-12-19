package dsa.shaurya.sorting;

public class InsertionSort {
	static int swap =0;
	public static void main(String[] args) {
		int a[] = {1,2,2,2,2,28,1};
//		int a[] = {5,1,6,2};
		sort(a);
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println("\nswap count "+swap);
	}
	
	static private void sort(int arr[]) {
		int v=0;
		for(int i=1;i<=arr.length-1;i++) {
			v = arr[i];
			int j = i;
			while(j>=1 && arr[j-1]>v) {
				arr[j] = arr[j-1];
				j--;
				swap++;
			}
			arr[j] = v;
		}
	}//sort

}
