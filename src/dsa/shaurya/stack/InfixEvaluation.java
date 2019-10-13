package dsa.shaurya.stack;

public class InfixEvaluation {

	public static int infixEvaluate(String exp) {
		int ans = 0;
		LinkedListStack<Integer> operandStack = new LinkedListStack<Integer>();
		LinkedListStack<Character> operatorStack = new LinkedListStack<Character>();
		
		char ch;
		for (int i = 0; i < exp.length(); i++) {
			ch=exp.charAt(i);
			if(isOperator(ch)) {
				
			}else if(Character.isDigit(ch)) {
				operandStack.push(ch-'0');
			}
		}
		
		
		return ans;
	}
	public static boolean isOperator(char ch) {
		if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%') {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		String exp = "";
		System.out.println(infixEvaluate(exp));
	}

}
