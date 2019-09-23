package dsa.shaurya.string;

public class CamelCase {

	
	static int camelCase(String s) {
		int count=1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String s ="saveChangesInTheEditor";
		System.out.println(camelCase(s));

	}

}
