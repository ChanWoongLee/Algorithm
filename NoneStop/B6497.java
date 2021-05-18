package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B6497 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			ArrayList<Node>[] graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			int total = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				graph[start].add(new Node(end, value));
				graph[end].add(new Node(start, value));
				total += value;
			}
			int dist = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			boolean[] visit = new boolean[N];
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (visit[now.node])
					continue;
				visit[now.node] = true;
				dist += now.value;

				for (Node node : graph[now.node]) {
					if (visit[node.node])
						continue;
					pq.add(new Node(node.node, node.value));
				}
			}
			System.out.println(total - dist);
		}
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
