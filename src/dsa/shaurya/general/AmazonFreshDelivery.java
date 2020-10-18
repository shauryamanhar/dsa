package dsa.shaurya.general;
import java.util.*;

public class AmazonFreshDelivery {
    public static void main(String[] args) {
        List<List<Integer>> alloc = new ArrayList<>();
        int nd =2;
        int a[][] = {{1,2},{3,2},{-3,2},{5,2}};       
        ArrayList<Integer> l = null;
        for(int i=0;i<a.length;i++) {
            l = new ArrayList<Integer>();
            l.add(a[i][0]);
            l.add(a[i][1]);
            alloc.add(l);
        }
        System.out.println(alloc);
        System.out.println("ans "+dPlan(alloc, nd));
    }
    static public List<List<Integer>> dPlan(List<List<Integer>> alloc,int nd){
        ArrayList<Location> list = new ArrayList<Location>();
        Location temp;
        for(int i=0;i<alloc.size();i++){
            temp = new Location(alloc.get(i).get(0),alloc.get(i).get(1));
            list.add(temp);            
        }
        Collections.sort(list);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nd;i++){
            Location l = list.get(i);
            List<Integer> tl = new ArrayList<>();
            tl.add(l.x);tl.add(l.y);
            ans.add(tl);
        }
        return ans;
    }
    static class Location implements Comparable<Location>{
        double squreRoot;
        int x,y;
        Location(int x,int y){
            this.x=x;
            this.y=y;
            squreRoot = Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)));
        }
        @Override
        public int compareTo(Location o) {
            if(squreRoot<o.squreRoot){
                return -1;
            }else if(squreRoot>o.squreRoot){
                return 1;
            }
            return 0;
        }
    }
}
