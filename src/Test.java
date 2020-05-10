import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

 public class Test {
	 public static void main(String args[] ) throws Exception {
	        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
	        String str = scan.readLine();
	        Long l;
	        while(str!=null && !str.isEmpty()) {
	        	l = new Long(str.trim());
	            System.out.println(count(l));
	            str = scan.readLine();
	        }
	    }

	    static int count(long n){
	        int c=0;
	        while(n>0){
	            n=n&(n-1);
	            c++;
	        }
	        return c;
	    }}