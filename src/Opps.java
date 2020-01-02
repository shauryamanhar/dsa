import java.util.*;

public class Opps {
	public static void main(String args[]){
		String s ="abcde";
//		String s ="giraffe";
		System.out.println("String length "+s.length());
		String special = "bd";
//		String special = "afgr";
		int k =2;
		int ans  = Integer.MIN_VALUE;
		int max=0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String temp = s.substring(i,j);
				int current=0;
				String cl = null;
				for(char ch:temp.toCharArray())
				{
					cl = temp;
					if(special.contains(ch+""))
						current++;
				}
				if(current<=k)
				{
					System.out.println("cl "+cl);
					if(temp.length()>max)
						max=temp.length();
				}
				//System.out.println(s.substring(i,j));
			}
		}//for
		System.out.println(max);
		
	}   //main
	public static void SubString(String str, int n) 
    { 
       for (int i = 0; i < n; i++)  
           for (int j = i+1; j <= n; j++) 
                System.out.println(str.substring(i, j)); 
    } 
  
}  //class
