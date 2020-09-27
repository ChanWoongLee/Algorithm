package Inha.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dijkstra {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int[][] graph = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[s][e] = v;
		}
		int[] dist = new int[V + 1];
		for (int i = 0; i < dist.length; i++)
			Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[V + 1];
		visit[start] = true;
		dist[start] = 0;
		Queue<Dijk> pq = new LinkedList<Dijk>();
		pq.add(new Dijk(start, 0));
		while (!pq.isEmpty()) {
			Dijk now = pq.poll();
			int node = now.node;
			int value = now.dist;
			for (int i = 1; i < graph.length; i++) {
				if (node == i)
					continue;
				if (visit[i])
					continue;
				if (graph[node][i] != 0) {
					if (dist[i] > dist[node] + graph[node][i]) {
						dist[i] = dist[node] + graph[node][i];
						visit[i] = true;
						pq.add(new Dijk(i, dist[i]));
					}
				}
			}
		}
		for(int i =1 ; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
			System.out.println(dist[i]);
		}
	}

}

class Dijk implements Comparable<Dijk> {
	int node, dist;

	public Dijk(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Dijk o) {
		if (this.dist > o.dist)
			return 1;
		else if (this.dist < o.dist)
			return -1;
		else
			return 0;
	}
}
