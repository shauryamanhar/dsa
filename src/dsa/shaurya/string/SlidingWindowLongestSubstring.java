package dsa.shaurya.string;


//this sliding window use to find the longest substring using with no duplicate 
public class SlidingWindowLongestSubstring {
	
	public static void main(String[] args) {
//		String s = "abrexrzx";
		String s = "ababcdef";
		longestSubstring(s);
	}
	
	
	static void longestSubstring(String s) {
		if(s.length()==0) {
			return;
		}
		int cnt[] = new int[26];//it for checking the duplicate
		int n = s.length();
		int i=0,j=0;int start=0,end=0;int max = -1,size=0;//i and j start with 0
		while(j<n) {
			if(cnt[s.charAt(j)-'a']==0) {//when j found unique character then increment the count
				cnt[s.charAt(j)-'a']++;
				j++;
				size++;
			}else {
				cnt[s.charAt(i)-'a']--;//when j cant find unique then i start moving forward
				i++;
				size--;
			}
			if(size>max) {//storing the start and end of longest substring
				start=i;end=j;
				max=size;
			}
		}
		for(int r=start;r<end;r++)
			System.out.print(s.charAt(r));//it print the longest substring
		System.out.println();
		System.out.println("max found "+max);
	}

}
