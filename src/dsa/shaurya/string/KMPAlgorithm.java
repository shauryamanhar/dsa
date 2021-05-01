package dsa.shaurya.string;

import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		String a = "ABABCABAACBAB";
		//TODO implement KMP
		computeLPSArray(a, a.length(), new int[a.length()]);
	}

	static void computeLPSArray(String pat, int M, int lps[]) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				} else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}//while
		int r=0;
		for(char c:pat.toCharArray()) {
			System.out.print(lps[r++]+",   ");
		}
	}

}
