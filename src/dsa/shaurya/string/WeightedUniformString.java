package dsa.shaurya.string;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class WeightedUniformString {

	static int weight(String s,TreeMap map) {
		int wt =0;
		for(int i=0;i<s.length();i++) {
			wt=wt+(int) map.get(new Character(s.charAt(i)));
		}
		return wt;
	}
	
	static String[] weightedUniformStrings(String s, int[] queries) {
		TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();
		int l=1;
		for(char i='a';i<='z';i++) {
			map.put(i, l++);
			i = (char)((int)i++);
		}
		
		
		TreeSet<String> list = new TreeSet<String>();
		int start =0, last=start;
		String u = new String();
		for(int i=0;i<s.length();i++) {
			start=i;
			last=start;
			u = s.charAt(i)+"";
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					u+=""+s.charAt(j);
					last++;
				}
			}//for
			list.add(u);
		}//for	
		
		List<Integer> ri = new LinkedList<Integer>();
		for(String op:list) {
			ri.add(weight(op, map));
		}
		ArrayList<String> result = new ArrayList<String>();
		for(int i:queries) {
			if(ri.contains(new Integer(i))) {
				result.add("YES");
			}else {
				result.add("NO");
			}
		}
		String m[] = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			m[i]=result.get(i);
		}
		return m;
    }
	
	
	public static void main(String[] args) {
		String s = "abccddde";
		int []queries = {
				1,
				3,
				12,
				5,
				9,
				10};
		for( String r:weightedUniformStrings(s, queries)) {
			System.out.println(r);
		}

	}

}
