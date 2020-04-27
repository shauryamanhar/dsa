import java.util.*;
public class April20CircutHackerEarthQ3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s= "BABA";
		char c[] = s.toCharArray();
		int countA=0;
		int countB=0;
		for(int i=0;i<c.length;i++) {
			if(c[i]=='A') {
				countA++;
			}else {
				countB++;
			}
		}
		
		int startA = 0;
		int endA = startA+countA-1;
		int startB = countA;
		int endB = endA+countB;
		System.out.println("count A "+countA);
		System.out.println("count B "+countB);
		int cnt=0;
		for(int i=startA;i<=endA;i++) {
			if(c[i]=='B') {
				cnt++;
			}
		}
		if(countA==0 || countB==0)
			System.out.println(0);
		else
			System.out.println(cnt<countB?cnt:countB);
		
	}
}

