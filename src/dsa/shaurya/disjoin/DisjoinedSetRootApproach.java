package dsa.shaurya.disjoin;

public class DisjoinedSetRootApproach {
	 int parent[] = null;
	 int size[] = null;
	 int n;
	 
	 public DisjoinedSetRootApproach(int n) {
		this.n = n;
		parent = new int[n+1];
		size = new int[n+1];
		for(int i = 0;i<=n;i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	 
	 int findroot(int a) {
		 while(a!=parent[a]) {
			 a = parent[a];
		 }
		 return a;
	 }
	 
	 boolean wunion(int a,int b) {
		 int ra = findroot(a);
		 int rb = findroot(b);
		 if(ra == rb) return false;
		 parent[rb] = ra;
		 size[ra] += size[rb];
		 size[rb] = -1;
		 return true;
	 }
}
