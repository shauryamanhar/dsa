package dsa.shaurya.recusion;

public class RecusiveDigitSum {
	static int i=0;
	public static void main(String[] args) {
		String n="11"
				+ "999999999999999"
				+ "999999999999999999999999999999999999999999"
				+ "99999999999999999999999999999999"
				+ "99999999999999999999999999999999"
				+ "9999999999999999999999989999911";
		int k=100000000;
//		int k=2;
		System.out.println(superDigit(n, k));;
//		System.out.println(sumOfDigit(n));

	}
	static boolean flag = false;
	static int superDigit(String n, int k) {
		if(n.length()==1) {
			return new Integer(n);
		}
		long sum = 0;
		if(flag==false) {
			for(int i=0;i<n.length();i++) {
				sum=sum+Character.getNumericValue(n.charAt(i));
			}
			sum = k*sum;
			flag=true;
			return superDigit(Long.toString(sum),k);
		}else {
			for(int i=0;i<n.length();i++) {
				sum=sum+Character.getNumericValue(n.charAt(i));
			}
			return superDigit(Long.toString(sum), k);
		}
		
		
    }
	
	static long sumOfDigit(String s) {
		long sum = 0;
		for(int i=0;i<s.length();i++) {
			sum=sum+((int)s.charAt(i));
		}
		return sum;
	}

}
