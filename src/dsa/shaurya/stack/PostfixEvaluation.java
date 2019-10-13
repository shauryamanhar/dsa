package dsa.shaurya.stack;

import java.util.Stack;

public class PostfixEvaluation {
	public static int operation(int a,int b,char op) {
		switch(op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
				return a*b;
		case '/':
				return a/b;
		case '%':
			return a%b;
		default:
			return -1;
		}
	}
	public static boolean isOperator(char op) {
		if(op=='+' || op=='-' || op=='*'|| op=='/' || op=='%') {
			return true;
		}else {
			return false;
		}
	}
	public static String evaluatePostfix(String exp) {
		exp = toPostfix(exp);
		Stack<Integer> stack = new Stack<>();
		char c ;
		for(int i=0;i<exp.length();i++) {
			c = exp.charAt(i);
			if(Character.isDigit(c)) {
				stack.push(Character.getNumericValue(c));
			}else if(isOperator(c)) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(operation(a, b, c));
			}
		}//for
		return stack.peek()+"";
		
	}
	
	
	public static int prec(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '%':
			return 3;
		default:
			return -1;

		}
	}
	public static String toPostfix(String exp) {
		StringBuffer ans = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		char ch;
		for(int i=0;i<exp.length();i++) {
			ch = exp.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				ans.append(ch);
			}else if(ch==')') {
				char temp = stack.peek();
				while(!stack.isEmpty() && temp!='(') {
					temp = stack.pop();
					if(temp!='(') {
						ans.append(temp);
					}
				}
			}
			else if(ch=='(' || isOperator(ch)) {
				while(!stack.isEmpty() && stack.peek()!='(' && prec(ch)>prec(stack.peek())) {
					ans.append(ch);
				}
				stack.push(ch);
			}
		}//for
		while(!stack.isEmpty()) {
			ans.append(stack.pop());
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		String exp = "(1+2)*(1+2)";
		System.out.println(evaluatePostfix(exp));

	}

}
