package dsa.shaurya.general;

import java.util.Iterator;
import java.util.List;

public class Test {
	public Object m() {
		Object o = new Float(3.14F);
		Object[]oa = new Object[5];
		oa[0] = o;
		o = null;
		oa[0]=null;
		return o;
	}
	public static int sum(List list) {
		int sum = 0;
		for(Iterator iter=list.iterator();iter.hasNext();) {
			int i = ((Integer)iter.next()).intValue();
			sum+=i;
		}
		return sum;
	}
}