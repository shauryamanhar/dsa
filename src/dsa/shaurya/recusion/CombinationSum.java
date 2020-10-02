package dsa.shaurya.recusion;
import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int a[] = {2,3,6,7};
        int target=7;
        List<ArrayList<Integer>> ans = new ArrayList<>(); 
        sum(a, a.length-1, target,new ArrayList<Integer>(),ans);
        System.out.println("ans is");
        for(ArrayList<Integer> l:ans) {
            System.out.println(l.toString());
        }
    }

    static void sum(int a[],int i,int target,ArrayList<Integer> list,List<ArrayList<Integer>> ans){
        if(target<0 || i <0){
            return;
        }
        if(target==0){
            ans.add((ArrayList<Integer>)list.clone());
            System.out.println("list added to ans "+ans.toString());
            return;
        }
        list.add(a[i]);
        sum(a,i,target-a[i],list,ans);
        list.remove(list.size()-1);
        sum(a,i-1,target,list,ans);
    }
}
