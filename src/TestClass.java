import java.util.Scanner;

class TestClass {

	private static long[] arr;
	private static int i,j,size;
	public static void main(String args[] ) throws Exception {
		Scanner sca = new Scanner(System.in);
		size = sca.nextInt();
		arr = new long[size];
		for(i=0;i<size;i++)
			arr[i]=sca.nextLong();
		boolean state = false;

		for(i=0;i<size;i++)
		{
			state = false;
			long data = arr[i];
			for(j=i+1;j<size;j++)
			{
				if(data<arr[j])
				{
					nextMin(j);
					state = true;
					break;
				}
			}
			if(!state)
			{
				System.out.print(-1+" ");
			}
		}

	}

	public static void nextMin(int i)
	{
		long data = arr[i];
		boolean state = false;
		for(int z=i+1;z<size;z++)
		{
			if(data>arr[z])
			{
				System.out.print(arr[z]+" ");
				state = true;
				break;
			}
		}
		if(!state)
		{
			System.out.print(-1+" ");
		}
	}

}