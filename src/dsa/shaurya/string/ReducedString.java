package dsa.shaurya.string;

public class ReducedString {

	static String reduce(String s) {
		if(s.length()==0) {
			return "Empty String";
		}
		StringBuilder sb = new StringBuilder(s);
		boolean flag = false;
		for(int i=0;i<sb.length()-1;i++) {
			if(sb.charAt(i)==sb.charAt(i+1)) {
				sb.replace(i, i+2, "");
				flag = true;
			}
		}
		if(flag==false) {
			return sb.toString();
		}
		return reduce(sb.toString());
	}
	public static void main(String[] args) {
		String s = "baab";
		System.out.println(reduce(s));
		//s = s.replaceAll("(.)\\1", "");
	}

}
