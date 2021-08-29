package dsa.shaurya.general;
import java.util.*;
public class ArrayReduction {
	public static void main(String[] args) {
		int []a = {1};
		List<Integer> list = new ArrayList<Integer>();
		for(int num:a) {
			list.add(num);
		}
		System.out.println(reductionCost(list));
	}
	public static int reductionCost(List<Integer> nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums);
		int totalCost = 0;
		while(!pq.isEmpty() && pq.size()>1) {
			int first = pq.poll();
			int second = pq.poll();
			int cost = first+second;
			totalCost+=cost;
			pq.offer(cost);
		}
		return totalCost;
	}
}
