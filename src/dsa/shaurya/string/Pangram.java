package dsa.shaurya.string;

import java.util.*;

public class Pangram {

	static String pangrams(String s) {
        Set<String> set = new TreeSet<String>();
        String r = null;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
            	r = new String(s.charAt(i)+"");
                set.add(r.toLowerCase());      
            }
        }
        System.out.println(set);
        if(set.size()==26){
            return "pangram";
        }else{
            return "not pangram";
        }

    }
	
	public static void main(String[] args) {
		String s = "qmExzBIJmdELxyOFWv LOCmefk TwPhargKSPEqSxzveiun";
		System.out.println(pangrams(s));

	}

}
