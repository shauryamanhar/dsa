package dsa.shaurya.recusion;

public class CombinationString {
	public static void main(String[] args) {
		String str = "abc";
		
		char c[] = str.toCharArray();
		printAll(c,0,str.length());
	}
	
	private static void printAll(char c[],int l,int r) {
		if(l>=r) {
			System.out.println(new String(c));
			return;
		}
		
		c[l] = Character.toUpperCase(c[l]);
		printAll(c, l+1, r);
		c[l] = Character.toLowerCase(c[l]);
		printAll(c, l+1, r);
		
	}//printAll
	
	
	
}
