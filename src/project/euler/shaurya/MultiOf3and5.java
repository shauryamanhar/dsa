package project.euler.shaurya;

//Problem 1. Find the sum of all the multiples of 3 or 5 below 1000.
public class MultiOf3and5 {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		int target = 999;
		int sum = 0;
		System.out.println("Sum is "+solve(a,b,target));
		sum = solveUsingFormula(3, target)+solveUsingFormula(5, target)-solveUsingFormula(15, target);
		System.out.println("Solve using formula: "+sum);

	}
	private static int solve(int a,int b,int target) {
		int sum = 0;
		for(int i=1;i<=target;i++) {
			if(i%a==0 || i%b==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	private static int solveUsingFormula(int n,int target) {
		int p = target/n;
		return (n*p*(p+1))/2;
	}
}
