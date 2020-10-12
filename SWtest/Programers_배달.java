package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Programers_¹è´Þ {

	public static void main(String[] args) {

	}

	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		boolean visit[] = new boolean[N + 1];
		int dist[] = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i < road.length; i++) {
			int start = road[i][0];
			int end = road[i][1];
			int value = road[i][2];
			if(graph[start][end] != 0 && graph[start][end] < value) {
				continue;
			}
			graph[start][end] = value;
			graph[end][start] = value;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		dist[1] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int start = now.node;
			int value = now.value;
			visit[start] = true;

			for (int i = 1; i < N + 1; i++) {
				if (graph[start][i] == 0 || visit[i])
					continue;
				if (dist[start] + graph[start][i] > dist[i])
					continue;
				dist[i] = dist[start] + graph[start][i];
				pq.add(new Node(i, graph[start][i]));
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] <= K)
				answer++;
		}
		return answer;
	}

	static class Node implements Comparable<Node> {
		int node, value;

		public Node(int node, int value) {
			super();
			this.node = node;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

	}
}
