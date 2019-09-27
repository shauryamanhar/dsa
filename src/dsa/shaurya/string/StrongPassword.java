package dsa.shaurya.string;

public class StrongPassword {
	static int minimumNumber(int n, String password) {
		String special = "!@#$%^&*()-+";
		char []sp = special.toCharArray();
		int count=0;;
		char c;
		int temp[] = new int[4];
		for(int i=0;i<password.length();i++) {
			c = password.charAt(i);
			if(c>='a' && c<='z') {
				temp[0]++;
			}
			if(c>='A' && c<='Z') {
				temp[1]++;
			}
			if(c>='0' && c<='9') {
				temp[2]++;
			}
			for(char m:sp) {
				if(m==c) {
					temp[3]++;
				}
			}
		}//for
		for(int r:temp) {
			if(r!=0) {
				count++;
			}
		}
		temp=null;
		sp=null;
		special=null;
		return (int)Math.max(4-count, 6-password.length());
		
    }
	public static void main(String[] args) {
		String password="AUzs-nV";
		int n=password.length();
		System.out.println(minimumNumber(n,password));

	}

}
