package dsa.shaurya;
import java.util.*;
import java.io.*;


//1
//2
//1 5 1 
//1 5 2
public class FlipCoins
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in); 
		int t=Integer.parseInt(scan.nextLine());
		while(t-->0){
            int G,I = 0,Q = 0;
            G = Integer.parseInt(scan.nextLine());
            String s = null;
            for(int i=0;i<G;i++){
            	s = scan.nextLine();
            	String []r = s.split(" ");
                I = Integer.parseInt(r[0]);//I for input head
                int N = Integer.parseInt(r[1]);
                Q = Integer.parseInt(r[2]);// Q for result
                System.out.println(solve(N,I,Q));
            }
            
            
		}//while
	}//main
	
	
	private static int solve(int N,int I,int Q){
		int result = 0;
		int i=0;
		if(I==1)
		{
			if(N==1)
			{
				if(Q==1)
				{
					result=0;
				}
				else
				{
					result=1;
				}
			}
			else if(N%2==0)
			{
				result=N/2;
			}
			else
			{              
				if(Q==1)
			{
				result=(int)N/2;
			}
			else
			{
				result=(int)(N/2)+1;
			}
			}
		}
		else if(I==2)
		{
			if(N==1)
			{
				if(Q==1)
				{              
					result=1;
				}
				else
				{
					result=0;
				}
			}
			else if(N%2==0)
			{
				result=N/2;
			}
			else
			{              
				if(Q==1)
			{
					result=(int)(N/2)+1;
			}
			else
			{
				result=(int)(N/2);
			}
			}
		}
		return result;

	}
	
	private static int solve(Long N,int I,int Q,int G){
	    Boolean coins[] = new Boolean[N.intValue()];
	    if(I==1){
	        for(int i=0;i<coins.length;i++){
	            coins[i]=true;
	        }
	    }else {
	    	for(int i=0;i<coins.length;i++){
	            coins[i]=false;
	        }
	    }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N-i;j++){
                coins[j]=!coins[j];
            }
        }
	    
	    int count =0 ;
	    if(Q==1){
	        for(int i=0;i<N;i++){
	            if(coins[i]==true){
	                count++;
	            }
	        }
	    }else{
	        for(int i=0;i<N;i++){
	            if(coins[i]==false){
	                count++;
	            }
	        }
	    }
	    return count;
	    
	}
}//codechef
