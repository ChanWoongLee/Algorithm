package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 {
	static int[][] dist2;
	static int N;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		dist2 = new int[N + 1][N + 1];
		for (int i = 0; i < dist2.length; i++) {
			Arrays.fill(dist2[i], 987654321);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, value));
		}
		dijk(x);
		for (int i = 1; i <= N; i++) {
			if (i == x)
				continue;
			dijk(i);
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (i == x)
				continue;
			ans = Math.max(ans, dist2[i][x] + dist2[x][i]);
		}
		System.out.println(ans);
	}

	static void dijk(int start) {
		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist2[start][start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.end])
				continue;
			visit[now.end] = true;

			for (Node no : graph[now.end]) {
				if (dist2[start][no.end] > dist2[start][now.end] + no.value) {
					dist2[start][no.end] = dist2[start][now.end] + no.value;
					pq.add(new Node(no.end, now.value + no.value));
				}
			}
		}

	}

	static class Node implements Comparable<Node> {
		int end, value;

		public Node(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

		public int compareTo(Node o) {
			return this.value - o.value;
		}

	}
}
