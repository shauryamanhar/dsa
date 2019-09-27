package dsa.shaurya.recusion;

public class SumOfNumber {

	public static void main(String[] args) {
		System.out.println(sum(2,3));

	}
	
	static int sum(int a,int b) {
		if(b==0) {
			return a;
		}
		return sum(a+1,b-1);
	}

}
