package dsa.shaurya.recusion;

public class SquareRoot {

	public static void main(String[] args) {
		int n = 2147395599;
		System.out.println(mySqrt(n));
	}
	
	static public int mySqrt(int x) {
		int l=0,r=x/2;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid<=x/mid && (mid+1)*(mid+1)>x){
                return (int)mid;
            }
            if(mid<x/mid){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
