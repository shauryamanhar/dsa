package samsung;

import java.util.*;
public class Marathon {
	static int finalTime = 0;
	static PaceInfo paceInfo[];
	static class PaceInfo {
		int timeSec;
		int energy;
	}//class
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int H=0,dist=0;
		paceInfo = new PaceInfo[6];
		for(int i=0;i<6;i++) {
			paceInfo[i] = new PaceInfo();
		}
		while(t-->0) {
			H = scan.nextInt();
			dist = scan.nextInt();
			int timeSec,timeMin,energy;
			for(int i=1;i<=5;i++) {
				timeMin = scan.nextInt();
				timeSec = scan.nextInt();
				energy = scan.nextInt();
				paceInfo[i].timeSec = timeMin*60+timeSec;
				paceInfo[i].energy = energy;
			}
			finalTime = Integer.MAX_VALUE;
			System.out.println();
			calculate(0,dist,H,1);
			System.out.println(finalTime/60);
			System.out.println(finalTime%60);
		}
	}//main



	private static void calculate(int curr_time, int remain_dist, int remain_energy, int paceIndex){
		if(curr_time>finalTime) {
			return;
		}
		if (remain_energy<0){
	        return;
	    }
		if (remain_dist <= 0){
	        if (curr_time < finalTime){
	            finalTime = curr_time;
	        }
	        return;
	    }
		if ((remain_dist * paceInfo[5].energy) > remain_energy){
	        return;
	    }
	    if (paceIndex == 1)
	        calculate(paceInfo[1].timeSec + curr_time, remain_dist - 1, remain_energy - paceInfo[1].energy, 1);
	    if (paceIndex == 2 || paceIndex == 1)
	        calculate(paceInfo[2].timeSec + curr_time, remain_dist - 1, remain_energy - paceInfo[2].energy, 2);
	    if (paceIndex == 3 || paceIndex == 1 || paceIndex == 2)
	        calculate(paceInfo[3].timeSec + curr_time, remain_dist - 1, remain_energy - paceInfo[3].energy, 3);
	    if (paceIndex == 4 || paceIndex == 1 || paceIndex == 2 || paceIndex == 3)
	        calculate(paceInfo[4].timeSec + curr_time, remain_dist - 1, remain_energy - paceInfo[4].energy, 4);
	    if (paceIndex == 5 || paceIndex == 1 || paceIndex == 2 || paceIndex == 3 || paceIndex == 4)
	        calculate(paceInfo[5].timeSec + curr_time, remain_dist - 1, remain_energy - paceInfo[5].energy, 5);
		
	}//calculate

}


/*
1
600(energy) 40(distance)
3 11 20
3 18 16
3 36 14
3 41 13
3 53 12
*/


