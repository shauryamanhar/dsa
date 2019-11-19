package dsa.shaurya.disjoin;

import java.util.*;

public class TestClass {
    int parent[] = null;
    int size[] = null;
    
    TestClass(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    int root(int a){
        while(parent[a]!=a){
            a = parent[a];
        }
        return a;
    }
    
    boolean union(int a,int b){
        int ra = root(a);
        int rb = root(b);
        if(ra==rb){
            return false;
        }
        parent[ra]=parent[rb];
        size[ra]+=size[rb];
        size[rb]=-1;
        return true;
    }//union
    
    void printSize(){
        ArrayList<Integer> list = (ArrayList) Arrays.asList(size);
        Collections.sort(list);
        for(int i:list){
            if(i==-1)
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner scan  = new Scanner(System.in);
        int n= scan.nextInt();
        TestClass t = new TestClass(n); 
        int m = scan.nextInt();
        int x,y;
        for(int i=0;i<m;i++){
            x= scan.nextInt();
            y=scan.nextInt();
            t.union(x,y);
            t.printSize();
        }
    }//main
}
