package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class K_d {

	public static void main(String[] args) {
		SolutionD s = new SolutionD();
		s.solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 },
				{ 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } });
	}

	static class SolutionD {
		static int[] dist;
		static ArrayList<Node>[] nodes;

		public int solution(int n, int s, int a, int b, int[][] fares) {
			int answer = 0;
			nodes = new ArrayList[n];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new ArrayList<>();
			}

			for (int i = 0; i < fares.length; i++) {
				nodes[fares[i][0] - 1].add(new Node(fares[i][1] - 1, fares[i][2]));
				nodes[fares[i][1] - 1].add(new Node(fares[i][0] - 1, fares[i][2]));
			}
			dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(s-1, nodes);
			System.out.println("sypq");
			return answer;
		}

		static class Node implements Comparable<Node> {
			int node;
			int cost;

			public Node(int node, int cost) {
				this.node = node;
				this.cost = cost;
			}

			@Override
			public int compareTo(Node o) {
				return this.cost - o.cost;
			}
		}

		void dijkstra(int start, ArrayList<Node>[] weights) {
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.add(new Node(start, 0));
			dist[start] = 0;

			Node cur;
			Node adjWeight;
			while (!pq.isEmpty()) {
				cur = pq.poll();
//				 if (cur.cost > dist[cur.node])
//				 continue;

				for (int adj = 0; adj < weights[cur.node].size(); adj++) {
					adjWeight = weights[cur.node].get(adj);

					if (dist[adjWeight.node] > adjWeight.cost + cur.cost) {
						dist[adjWeight.node] = adjWeight.cost + cur.cost;
						pq.add(new Node(adjWeight.node, dist[adjWeight.node]));
					}
				}
			}
		}
	}
}
