package dsa.shaurya.greedyalgorithms;

public class BuyAndSell {
    public static void main(String[] args) {
        int a[] = {7,1,5,3,6,4};
        profit(a);   
    }

    static void profit(int a[]){
        int buy=0,sell=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]<a[i+1]){
                buy=i;
                System.out.println("buy "+a[i]);
            }
        }
    }
}
