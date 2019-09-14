package dsa.shaurya.recusion;

public class Necklace {

	public static void main(String[] args) {
		String s ="byb";
		System.out.println(neck(s,0));
	}
	
	static int neck(String s,int l) {
		System.out.println(s);
		if(s.charAt(l)=='r') {
			return neck(s+"b",l+1);
		}else if(s.charAt(l)=='y') {
			return neck(s+"g",l+1);
		}else if(s.charAt(l)=='y') {
			return neck(s+"r",l+1);
		}else if(s.charAt(l)=='b') {
			return neck(s+"y",l+1);
		}else {
			return l;
		}
	}

}
