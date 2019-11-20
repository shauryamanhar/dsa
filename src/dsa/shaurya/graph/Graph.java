package dsa.shaurya.graph;

import java.util.*;
import java.io.*;

public class Graph {
	private int vertex;
	private LinkedList<Integer> adj[];
	private int distance[];

	public Graph(int v) {
		vertex = v;
		adj = new LinkedList[v];
		distance = new int[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
			distance[i] = 0;
		}
	}

	public void addEdge(int s, int d) {
		adj[s].add(d);
		adj[d].add(s);
	}

	public int bfs(int s, int t) {
		boolean visited[] = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			distance[i] = 0;
			visited[i] = false;
		}

		int count = 0;

		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);
		while (q.size() != 0) {
			int temp = q.poll();

			Iterator<Integer> i = adj[temp].listIterator();
			while (i.hasNext()) {
				int x = i.next();

				if (visited[x] == false) {
					visited[x] = true;
					distance[x] = distance[temp] + 1;
					if (distance[x] == t)
						count++;
					q.add(x);
				}
			}
		}

		return count;

	}

}

class ClassTest {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l[] = br.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		Graph g = new Graph(n);
		int e = Integer.parseInt(l[1]);
		StringBuffer sb = new StringBuffer();
		while (e-- > 0) {
			String edge[] = br.readLine().split(" ");
			g.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			String q[] = br.readLine().split(" ");
			sb.append(g.bfs(Integer.parseInt(q[0]), Integer.parseInt(q[1])));
			sb.append("\n");
		}
		System.out.print(sb);

	}
}