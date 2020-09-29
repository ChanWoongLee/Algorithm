package Acmicpc부순다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		ArrayList<Dijk>[] graph = new ArrayList[V + 1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[s].add(new Dijk(e, v));
		}
		int[] dist = new int[V + 1];
		for (int i = 0; i < dist.length; i++)
			Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[V + 1];
		dist[start] = 0;
		PriorityQueue<Dijk> pq = new PriorityQueue<Dijk>();
		pq.add(new Dijk(start, 0));
		

		while (!pq.isEmpty()) {
			Dijk now = pq.poll();
			int node = now.node;
			if (visit[node])
				continue;
			visit[node] = true;
			for (int i = 0; i < graph[node].size(); i++) {
				int adj_node = graph[node].get(i).node;
				int weight = graph[node].get(i).dist;
				if (dist[adj_node] > dist[node] + weight) {
					dist[adj_node] = dist[node] + weight;
					pq.add(new Dijk(adj_node, dist[adj_node]));
				}
			} // 가능한 dist 초기화 및 간선 정보 pq에 삽입
		}
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
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
		return this.dist - o.dist;
	}
}
