package dsa.shaurya.sorting;

public class BubbleSort {
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
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					swap++;
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}//sort

}
