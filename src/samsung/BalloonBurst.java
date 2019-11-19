package samsung;

import java.util.*;
public class BalloonBurst {
	static int balloon[] = new int[100];
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int t;
		t=scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			balloon[0]=1;
			balloon[n+1]=1;
			for(int i=1;i<=n;i++) {
				balloon[i]=scan.nextInt();
			}
			int ans = getMaxPoint(0,n+1,n);
			System.out.println(ans);
		}
		
		
	}//main
	static int getMaxPoint(int left,int right,int n) {
		int maxScore = 0;
		for(int i = left+1;i<right;i++) {
			int currentScore = 0;
			currentScore = getMaxPoint(left, i, n)+getMaxPoint(i, right, n);
			if(left==0 && right==n+1) {
				currentScore+=balloon[i];
			}else {
				currentScore=currentScore+(balloon[left]*balloon[right]);
			}
			//update score
			if(currentScore>maxScore) {
				maxScore = currentScore;
			}
		}
		return maxScore;
	}
}
