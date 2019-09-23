package dsa.shaurya.recusion;

import java.util.ArrayList;

public class ThePowerSum {
	
	static int power(int a,int n) {
		if(n==0) {
			return 1;
		}else {
			return a*power(a,n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(countExpression(29, 2, new ArrayList<Integer>()));
	}

	private static int countExpression(int x, int n, ArrayList<Integer> numList) {
		
		int sum=0;
		int answer = 0;
		for(int v:numList) {
			sum+=power(v,n);
		}//for
		
		if(sum==x) {
			//found the solution
			return 1;
		}else {
			int v;
			if(numList.isEmpty()) {
				v = 1;
			}else {
				v = numList.get(numList.size()-1)+1;
			}
			
			while(sum+power(v,n)<=x) {
				numList.add(v);
				answer+=countExpression(x, n, numList);
				numList.remove(new Integer(v));
				v++;
			}
		}
		
		return answer;
	}

}
