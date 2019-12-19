package dsa.shaurya;

public class PermutationOfString {

	public static void main(String[] args) {
		String s = "ABC";
		char ch[] = s.toCharArray();
		permutation(ch, 0, ch.length-1);
	}
	static private void permutation(char []ch,int l,int r) {
		if(l==r) {
			System.out.println(new String(ch));
		}else {
			for(int i = l;i<=r;i++) {
				swap(ch,l,i);
				permutation(ch, l+1, r);
				swap(ch,l,i);
			}
		}
	}//permutation
	
	static private void swap(char ch[],int l,int r) {
		char temp = ch[l];
		ch[l]=ch[r];
		ch[r]=temp;
	}

}
