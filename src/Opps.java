import java.util.*;

public class Opps {
	public static void main(String args[]){
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(4);
		l.add(2);
		l.add(9);
		Collections.sort(l);
		for(int i:l) {
			System.out.println(i);
		}
	}   //main
}  //class
