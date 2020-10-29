package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1197_use_PRIM {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] ar = new ArrayList[V + 1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			ar[start].add(new Node(end, value));
			ar[end].add(new Node(start, value));
		}
		int answer = 0;
		boolean[] visit = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.num])
				continue;
			visit[now.num] = true;
			answer += now.value;
			int node = now.num;
			for (int i = 0; i < ar[node].size(); i++) {
				Node friend = ar[node].get(i);
				if (visit[friend.num])
					continue;
				pq.add(friend);

			}
		}
		System.out.println(answer);
	}

	static class Node implements Comparable<Node> {
		int num;
		int value;

		public Node(int num, int value) {
			this.num = num;
			this.value = value;
		}

		public int compareTo(Node other) {
			return this.value - other.value;
		}
	}
}
