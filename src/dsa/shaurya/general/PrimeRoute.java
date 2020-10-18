package dsa.shaurya.general;

import java.util.*;

public class PrimeRoute {
    public static void main(String[] args) {
        List<List<Integer>> fr = new ArrayList<>();
        List<List<Integer>> rr = new ArrayList<>();
        int md=7000;
        int a[][] = {{1,2000},{2,4000},{3,6000}};
        int b[][] = {{1,2000}};
        List<Integer> l;
        for(int t[]:a){
            l = new ArrayList<>();
            l.add(t[0]);
            l.add(t[1]);
            fr.add(l);
        }
        for(int t[]:b){
            l = new ArrayList<>();
            l.add(t[0]);
            l.add(t[1]);
            rr.add(l);
        }
        routePair(md, fr, rr);
    }
    static List<List<Integer>> routePair(int md,List<List<Integer>> fr,List<List<Integer>> rr){
        ArrayList<Pair> list = new ArrayList<>();

        for(List<Integer> f:fr){
            for(List<Integer> r:rr){
                Pair p = new Pair();
                p.id1=f.get(0);
                p.dis1=f.get(1);
                p.id2=r.get(0);
                p.dis2=r.get(1);
                p.sumDis=p.dis1+p.dis2;
                list.add(p);
            }
        }
        Collections.sort(list);
        int max = -1;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i).sumDis && list.get(i).sumDis<=md){
                max=list.get(i).sumDis;
            }
        }
        System.out.println("max found "+max);
        return null;
    }
    static class Pair implements Comparable<Pair>{
        int id1,id2;
        int dis1,dis2;
        int sumDis;
        @Override
        public int compareTo(Pair arg0) {
            return sumDis-arg0.sumDis;
        }
        @Override
        public String toString() {
            return id1+" "+id2;
        }       
    }
}
