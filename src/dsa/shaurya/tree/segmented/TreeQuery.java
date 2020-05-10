package dsa.shaurya.tree.segmented;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class TreeQuery {
 
    static int max = 5_0;
    static ArrayList<Integer>[] adj;
    static int[] st = new int[max];
    static int[] ft = new int[max];
    static int[] is = new int[max];
    static int max2 = 2 * (1 << (int) Math.ceil(Math.log(max) / Math.log(2)));
    static int[] t = new int[max2];
    static int[] mn = new int[max2];
    static int[] add = new int[max2];
    static int next = -1;
    
    static void print(int a[],String name) {
    	System.out.println("+++++ "+name+"++++++");
    	for(int r:a) {
    		System.out.print(r+" ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
        new Thread(null, TreeQuery::solve, "1", 1 << 26).start();
    }
 
    public static void solve() {
        Scanner f = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = f.nextInt();
        int q = f.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = f.nextInt() - 1;
            int v = f.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(0, -1);
        print(st,"st");
        print(ft,"ft");
        build(0, n - 1, 1);
        while (q-- > 0) {
            int a = f.nextInt();
            int b = f.nextInt() - 1;
            if (a == 1) {
                add(st[b], ft[b], is[b] == 0 ? 1 : -1, 0, n - 1, 1);
                is[b] ^= 1;
            } else {
                if (is[b] == 1) {
                    pw.println(0);
                } else {
                    pw.println(get(st[b], ft[b], 0, n - 1, 1).b);
 
                }
            }
        }
        pw.flush();
    }
 
    private static Pair get(int l, int r, int s, int e, int v) {
        Pair p = new Pair();
        if (l <= s && e <= r) {
            p.a = mn[v];
            p.b = t[v];
            return p;
        }
        if (r < s || e < l)
            return p;
        int m = (s + e) / 2;
        Pair p1 = get(l, r, s, m, 2 * v);
        Pair p2 = get(l, r, m + 1, e, 2 * v + 1);
        p.a = Math.min(p1.a, p2.a);
        if (p.a == p1.a)
            p.b += p1.b;
        if (p.a == p2.a)
            p.b += p2.b;
        p.a += add[v];
        return p;
    }
 
    private static void dfs(int curr, int parent) {
        st[curr] = ++next;
        for (int i = 0; i < adj[curr].size(); i++) {
            if (adj[curr].get(i) != parent) {
                dfs(adj[curr].get(i), curr);
            }
        }
        ft[curr] = next;
    }
 
    static void build(int s, int e, int v) {
        t[v] = e - s + 1;
        if (s < e) {
            int mid = (s + e) / 2;
            build(s, mid, 2 * v);
            build(mid + 1, e, 2 * v + 1);
        }
 
    }
 
 
    static void add(int l, int r, int val, int s, int e, int v) {
        if (l <= s && e <= r) {
            mn[v] += val;
            add[v] += val;
            return;
        }
        if (r < s || e < l) {
            return;
        }
        int m = (s + e) / 2;
        add(l, r, val, s, m, 2 * v);
        add(l, r, val, m + 1, e, 2 * v + 1);
        mn[v] = Math.min(mn[2 * v], mn[2 * v + 1]);
        t[v] = 0;
        if (mn[v] == mn[2 * v]) {
            t[v] += t[2 * v];
        }
        if (mn[v] == mn[2 * v + 1]) {
            t[v] += t[2 * v + 1];
        }
        mn[v] += add[v];
    }
}
 
class Pair {
    int a = Integer.MAX_VALUE, b = 0;
}
 