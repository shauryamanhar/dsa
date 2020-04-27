import java.util.Scanner;

 public class Test {
	private static int []a;
	private static int []tree;

	private static void build(int node, int start, int end) {
		// base case here is leaf node
		if(start == end) {
			tree[node] = a[start];
		}
		else {
			int mid = (start+end)/2;
			int lchild = 2*node+1;
			int rchild = 2*node+2;

			build(lchild, start, mid);
			build(rchild, mid+1, end);

			tree[node] = Math.min(tree[2*node+1], tree[2*node+2]);
		}
	}

	private static void update(int node, int start, int end, int uind, int udata) {
		//reached to leaf node
		if(start == end) {
			tree[node] = a[uind] = udata;
		}
		else {
			int mid = (start+end)/2;
			int lch = 2*node+1;
			int rch = 2*node+2;

			if(uind <= mid)
				update(lch, start, mid, uind, udata);
			else
				update(rch, mid+1, end, uind, udata);

			tree[node] = Math.min(tree[lch], tree[rch]);
		}
	}

	private static int query(int node, int start, int end, int l, int r) {
		// case 1 : no overlapping
		if(r < start || l > end) {
			return Integer.MAX_VALUE;
		}
		// case 2 : Full overlapping
		else if(start >= l && end <= r) {
			return tree[node];
		}
		// Case 3 : partial overlapping
		else {
			int mid = (start+end)/2;
			int lchild = 2*node+1;
			int rchild = 2*node+2;

			return Math.min (query(lchild, start, mid, l, r), query(rchild, mid+1, end, l, r));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();

		a = new int[N]; // memory given to array
		tree = new int [4*N]; // this is th max memory required by segment array

//		reset(0, 4*N-1);

		int ind = 0;

		// collection will take arnd O(n) time
		for(; ind < N; ++ind) {
			a[ind] = in.nextInt();
		}

		// build tree
		build(0,0,N-1);
		System.out.println("\n++++++build ++++");
		for(int i1=0;i1<a.length;i1++) {
			System.out.print(a[i1]+" ");
		}
		System.out.println("\n++++++++++");
		for(int i1=0;i1<tree.length;i1++) {
			System.out.print(tree[i1]+" ");
		}
		System.out.println("\n++++++++++");		
		// build tree

		// now read the Q query/update from the input stream
		ind = 0;
		for(; ind < Q; ++ind) {

			char op = in.next().charAt(0); // assuming that one character only
			int arg1 = in.nextInt();
			int arg2 = in.nextInt();

			switch(op) {
			case 'q':
				// arg1 and arg2 here is non zeor index so before sending in method , convert it
				int res = query(0, 0,N-1, arg1-1, arg2-1);
				System.out.println(res);
				break;

			case 'u':
				update(0,0, N-1, arg1-1, arg2); // here arg1 is index so convert to zero, arg2 is value
				System.out.println("\n+++++++ update  +++");
				for(int i1=0;i1<a.length;i1++) {
					System.out.print(a[i1]+" ");
				}
				System.out.println();
				for(int i=0;i<tree.length;i++) {
					System.out.print(tree[i]+" ");
				}
				System.out.println("\n++++++++++");
				break;
			}
		}

		in.close();
	}
}