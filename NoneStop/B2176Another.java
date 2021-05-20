package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2176Another {
	static int[][] dist;
	static ArrayList<Edge>[] graph;
	static int n;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[start].add(new Edge(end, value));
			graph[end].add(new Edge(start, value));
		}
		dist = new int[n + 1][n + 1];
		cnt = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i != j)
					dist[i][j] = 987654321;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i == 2)
				continue;
			dijk(i);
		}
		recur(1);
		System.out.println(cnt[1]);
	}

	static int recur(int node) {
		if(node == 2)
			return 1;
		
		if(node != 1 && cnt[node] != 0)
			return cnt[node];
		
		for (Edge e : graph[node]) {
			if (dist[node][2] > dist[e.end][2]) {
				cnt[node] += recur(e.end);
			}
		}
		return cnt[node];
	}

	static void dijk(int node) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		pq.add(new Edge(node, 0));
		boolean[] visit = new boolean[n + 1];
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.end])
				continue;
			visit[now.end] = true;
			for (Edge ar : graph[now.end]) {
				if (visit[ar.end])
					continue;
				if (dist[node][ar.end] > dist[node][now.end] + ar.value) {
					dist[node][ar.end] = dist[node][now.end] + ar.value;
					pq.add(new Edge(ar.end, dist[node][ar.end]));
				}
			}
		}
	}

	static class Edge {
		int end, value;

		public Edge(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

	}
}
