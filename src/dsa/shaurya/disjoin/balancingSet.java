package dsa.shaurya.disjoin;

public class balancingSet {

	static void init(int arr[],int size[],int n) {
		for(int i=0;i<n;i++) {
			arr[i]=i;
			size[i]=1;
		}
	}
	//get the root() and find method from SetRootApproach
	static int root(int arr[],int a) {
		while(arr[a]!=a) {
			a=arr[a];
		}
		return a;
	}
	
	static boolean find(int arr[],int a,int b) {
		return root(arr,a)==root(arr,b);
	}
	
	//The union function will be modified because the two subsets will be connected based on the number of elements in each subset.
	static void weightedUnion(int arr[],int a,int b,int size[]) {
		int rootA = root(arr,a);
		int rootB = root(arr,b);
		if(size[rootA]<size[rootB]) {
			arr[rootA]=rootB;
			size[rootB]+=size[rootA];
		}else {
			arr[rootB]=rootA;
			size[rootA]+=size[rootB];
		}
		
	}//weight
	
	
	
	
	
	public static void main(String[] args) {
		
	}

}
