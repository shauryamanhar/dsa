package dsa.shaurya.recusion;

public class IncrementDecrement {
	private static int printIncrement(int i,int n) {
		if(i==n) {
			return n;
		}
		System.out.println(i);
		return printIncrement(i+1,n);
	}
	
	private static void printIncrement1(int n) {
		if(n==0) {
			return;
		}
		printIncrement1(n-1);
		System.out.println(n);
	}
	
	private static void printDecrement(int n) {
		if(n==0) {
			return ;
		}
		System.out.println(n);
		printDecrement(n-1);
	}
	public static void main(String[] args) {
//		System.out.println(printIncrement(1,5));
		printIncrement1(5);
//		printDecrement(5);

	}

}
