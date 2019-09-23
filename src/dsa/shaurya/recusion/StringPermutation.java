package dsa.shaurya.recusion;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
	void permute(char []input) {
		Map<Character, Integer> countMap = new TreeMap<Character, Integer>();
		for(Character ch:input) {
			if(countMap.containsKey(ch)){
				countMap.put(ch, countMap.get(ch)+1);
			}else {
				countMap.put(ch, 1);
			}
		}//for
		
		System.out.println(countMap);
		char[] str = new char[countMap.size()];
		int[] count = new int[countMap.size()];
		
		int index = 0;
		for(Map.Entry<Character, Integer> entry:countMap.entrySet()) {
			str[index]=entry.getKey();
			count[index]=entry.getValue();
			index++;
		}//for
		
		char[] result = new char[input.length];
		
		permuteUtil(str,count,result,0);
		
		
	}
	private void permuteUtil(char[] str, int[] count, char[] result, int level) {
		if(level==result.length) {
			printArray(result);
			return;
		}
		
		for(int i=0;i<str.length;i++) {
			if(count[i]==0) {
				continue;
			}
			result[level]=str[i];
			count[i]--;
			permuteUtil(str,count,result,level+1);
			count[i]++;
		}
		
	}
	private void printArray(char[] str) {
		for(char c:str) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		StringPermutation s = new StringPermutation();
		char str[] = "AABC".toCharArray();
		s.permute(str);

	}

}
