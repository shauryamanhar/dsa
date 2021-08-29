package dsa.shaurya.general;

import java.util.*;

public class ConfereceSchedule {
	public static void main(String[] args) {
		System.out.println(maxPresentation(Arrays.asList(1,1,2,3), Arrays.asList(2,3,3,4)));
		System.out.println(maxPresentation(Arrays.asList(6,1,2,3), Arrays.asList(8,9,4,7)));
		System.out.println(maxPresentation(Arrays.asList(1,3,4,6), 
										   Arrays.asList(2,4,5,7)));
	}
	static int maxPresentation(List<Integer> start,List<Integer> end) {
		int len = start.size();
		List<Meeting> m = new ArrayList<>();
		for(int i=0;i<len;i++) {
			m.add(new Meeting(start.get(i),end.get(i)));
		}
		Comparator<Meeting> comp = (a,b)->{
			if(a.e<b.e) {
				return -1;
			}else if(a.e>b.e) {
				return 1;
			}else {
				return 0;
			}
		};
		Collections.sort(m,comp);
		int count=1;
		int currTime = m.get(0).e;
		for(int i=1;i<len;i++) {
			if(m.get(i).s>=currTime) {
				count++;
				currTime = m.get(i).e;
			}
		}
		return count;
	}
	static class Meeting{
		int s,e;
		Meeting(int s,int e){
			this.s=s;
			this.e=e;
		}
		@Override
		public String toString() {
			return s+" "+e;
		}
	}
}
