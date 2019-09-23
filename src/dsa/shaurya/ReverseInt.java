package dsa.shaurya;

public class ReverseInt {
	static int rev(int x) {
		Long rev = 0L;
		boolean flag = false;
		if (x < 0) {
			flag = true;
			x = -x;
		}
		while (x > 0) {
			if (rev >= Integer.MAX_VALUE/10) {
				return 0;

			}
			rev = (Long) (rev * 10 + x % 10);
			x = x / 10;
		}
		rev = flag == true ? -rev : rev;
		return rev.intValue();
	}
	public static void main(String[] args) {
//		System.out.println(rev(1534236469));
//		System.out.println(rev(-2143847412));
		System.out.println(Integer.MAX_VALUE);

	}

}
