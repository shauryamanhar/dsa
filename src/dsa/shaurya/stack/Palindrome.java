package dsa.shaurya.stack;

import java.util.Stack;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		Stack<Character> stack = new Stack<>();
		int i=0;
		for(i=0;i<(s.length()/2);i++) {
			stack.push(s.charAt(i));
		}
		if((s.length())%2!=0) {
			i++;
		}
		boolean isPalindrome = true;
		while(!stack.isEmpty() && i<s.length()) {
			if(stack.pop()!=s.charAt(i)) {
				isPalindrome=false;
			}
			i++;
		}
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		String s = "ab121ba";
		System.out.println(isPalindrome(s));
	}

}
