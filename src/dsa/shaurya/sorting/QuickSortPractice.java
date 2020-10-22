package dsa.shaurya.sorting;

import java.util.Arrays;

public class QuickSortPractice {
    public static void main(String[] args) {
        int a[] = {4,6,2,9,3,7,5};

        System.out.println(Arrays.toString(a));
        int low=0,high=a.length-1;
        quickSort(a, low, high);
        System.out.println(Arrays.toString(a));
    }
    static void quickSort(int a[],int low,int high){
        if(low<high){
            int pivot = pivot(a,low,high);
            quickSort(a, low, pivot-1);
            quickSort(a, pivot+1, high);
        }
    }
    static int pivot(int a[],int low,int high){
        int i=low-1;
        int j=low;
        int pivot = a[high];
        while(j<high){
            if(a[j]<pivot){
                i++;
                swap(a, i, j);
            }
            j++;
        }
        swap(a, i+1, high);
        return i+1;
    }
    static private void swap(int a[],int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
