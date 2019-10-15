package dsa.shaurya;
import java.util.*;
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int k=0; k<t; k++)
		{
			int n= sc.nextInt();
			int count=0;
			int p[]= new int[n];
			for(int i=0; i<n; i++)
			{
				p[i]= sc.nextInt();
			}
			for(int i=0; i<n; i++)
			{
				if(i==0)
					count++;
				else if(i==1)
				{
					if(p[i]<p[i-1])
					{
						count++;
					}
				}
				else if(i==2)
				{
					if(p[i]<p[i-1] && p[i]<p[i-2])
					{
						count++;
					}
				}
				else if(i==3)
				{
					if(p[i]<p[i-1] && p[i]<p[i-2] && p[i]<p[i-3])
					{
						count++;
					}
				}
				else if(i==4)
				{
					if(p[i]<p[i-1] && p[i]<p[i-2] && p[i]<p[i-3] && p[i]<p[i-4])
					{
						count++;
					}
				}
				else
				{
					if(p[i]<p[i-1] && p[i]<p[i-2] && p[i]<p[i-3] && p[i]<p[i
					                                                       -4] && p[i]<p[i-5])
					{
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}