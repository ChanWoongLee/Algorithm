package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2176 {
	static int[] dist;
	static ArrayList<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
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
		dist = new int[n + 1];
		int[] cnt = new int[n + 1];
		cnt[2] = 1;
		Arrays.fill(dist, 987654321);
		dist[2] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		pq.add(new Edge(2, 0));
		boolean[] visit = new boolean[n + 1];
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.end])
				continue;
			visit[now.end] = true;
			for (Edge ar : graph[now.end]) {
				if (visit[ar.end])
					continue;
				if (dist[ar.end] > dist[now.end] + ar.value) {
					dist[ar.end] = dist[now.end] + ar.value;
					pq.add(new Edge(ar.end, dist[ar.end]));
				}
				if (now.value < dist[ar.end]) {
					cnt[ar.end] += cnt[now.end];
				}
			}
		}
		System.out.println(cnt[1]);
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
