package dsa.shaurya.sorting;

public class SelectionSort {
	static int swap =0;
	public static void main(String[] args) {
		int a[] = {1,2,2,2,2,28,1};
		sort(a);
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println("\nswap count "+swap);
	}
	
	static private void sort(int arr[]) {
		int min =Integer.MAX_VALUE ;
		for(int i=0;i<arr.length;i++) {
			min = arr[i];
			int j=0;
			for(j=0;j<arr.length-1;j++) {
				if(min>arr[j]) {
					min = arr[j];
				}
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			swap++;
		}
	}//sort

}
