package dsa.shaurya.recusion;

public class Combination {

	public static void main(String[] args) {
		char []input = "ABCD".toCharArray();
		String result = new String();
		int i=0;
		int j=i+1;
		int r=2;
		combination(input,result,i,j,r);
	}

	private static void combination(char[] input, String result, int i, int j, int r) {
		if(result.length()==r) {
			System.out.println(result);
		}
		if(j>=input.length && i<j) {
			return;
		}
//		System.out.println("i "+i+" j "+j);
		combination(input, result, i, j+1, r);
		System.out.println(input[i]+""+input[j]);
		combination(input, result, i+1, j+1, r);
		
	}

}
