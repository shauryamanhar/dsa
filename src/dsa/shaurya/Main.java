package dsa.shaurya;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int x=scan.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		for(int i=0;i<n;i++) {
			a[i] =scan.nextInt();
		}
		for(int i=0;i<m;i++) {
			b[i] =scan.nextInt();
		}
		System.out.println(twoStacks(x, a, b));

	}
	static int twoStacks(int x, int[] a, int[] b) {
		Stack<Integer> astack = new Stack<Integer>();
        Stack<Integer> bstack = new Stack<Integer>();
        for(int i=a.length-1;i>=0;i--){
            astack.push(a[i]);
        }
        for(int i=b.length-1;i>=0;i--){
            bstack.push(b[i]);
        }

        int count=0;
        int sum = 0;
        while(sum<=x){
            if(!astack.isEmpty() && !bstack.isEmpty()){
                sum = sum+astack.pop()+bstack.pop();;
                count=count+2;    
            }

            if(!astack.isEmpty()){
                sum = sum+astack.pop();;
                count++;    
            }
            if(!bstack.isEmpty()){
                sum = sum+bstack.pop();
                count++;
            }   
        }
        return count;
    }

}
