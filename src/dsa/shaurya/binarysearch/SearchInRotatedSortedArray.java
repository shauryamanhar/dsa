package dsa.shaurya.binarysearch;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = {4,5,6,7,0,1,2};
		int t = 4;
		System.out.println(search(a, t));

	}
	static int search(int[] a, int target) {
        int l =0,r=a.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]==target){
                return mid;
            }else if(a[l]<=a[mid]){//strictly increasing from left to mid
                if(a[mid]>=target && a[l]<=target){//check target is in the between l and mid
                    r = mid-1;
                }else{//not found
                    l = mid+1;
                }
            }else{//right strictly increasing from mid to r
                if(a[r]>=target && target>=a[mid]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    } 

}
