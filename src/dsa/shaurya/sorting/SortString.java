package dsa.shaurya.sorting;

import java.util.Scanner;

public class SortString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		MergeSortString sort;
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String a[] = new String[n];
			sort  = new MergeSortString();
			for(int j=0;j<n;j++) {
				a[j]=sc.next();
			}
			sort.mergeSort(0, n-1, a);
			System.out.println("#"+i);
			String unique = "";
			for(int r=a.length-1;r>=0;r--) {
				if(com(unique,a[r])!=0) {
					System.out.println(a[r]);
					unique=a[r];
				}
			}
			
		}
	}
	
	
	static int com(String s1,String s2) {
		if(s1.length()<s2.length()) {
			return -1;
		}else if(s1.length()>s2.length()) {
			return 1;
		}else {
			char c1,c2;
			for(int i=0;i<s1.length();i++) {
				c1=s1.charAt(i);c2=s2.charAt(i);
				if(c1<c2) {
					return -1;
				}else if(c1>c2) {
					return 1;
				}
			}
		}
		return 0;
	}//com
	static class MergeSortString{
		void merge(int l,int mid,int r,String a[]) {
			int n1=mid-l+1;
			int n2=r-mid;
			String L[] = new String[n1];
			String R[] = new String[n2];
			int i,j,k;
			for(i=0;i<n1;i++) {
				L[i]=a[l+i];
			}
			for(j=0;j<n2;j++) {
				R[j]=a[mid+1+j];
			}
			
			
			i=0;
			j=0;
			k=l;
			
			while(i<n1 && j<n2) {
				if(com(L[i],R[j])==1 || com(L[i],R[j])==0 ) {
					a[k]=L[i];
					i++;
				}else {
					a[k]=R[j];
					j++;
				}
				k++;
			}
			while (i < n1){ 
		        a[k] = L[i]; 
		        i++; 
		        k++; 
		    } 
		  
		    while (j < n2){ 
		        a[k] = R[j]; 
		        j++; 
		        k++; 
		    } 
		}
		void mergeSort(int l,int r,String a[]) {
			if(l<r) {
				int mid = l+(r-l)/2;
				mergeSort(l, mid, a);
				mergeSort(mid+1, r, a);
				merge(l,mid,r,a);
			}
		}
	}
}
