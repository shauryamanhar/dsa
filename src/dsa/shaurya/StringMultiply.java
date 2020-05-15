package dsa.shaurya;

public class StringMultiply {

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));

	}
	
	public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int vals[] = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');//multiply
                int sum = vals[i+j+1]+mul;//add carry
                vals[i+j]+=sum/10;//store carry to left index
                vals[i+j+1]=sum%10; //store multiple to currect index
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean f=false;
        for(int i=0;i<vals.length;i++) {
        	if(vals[i]!=0) {
        		f=true;
        	}
        	if(f) {
        		sb.append(vals[i]);
        	}
        }
        return sb.toString().isEmpty()?"0":sb.toString();
    }

}
