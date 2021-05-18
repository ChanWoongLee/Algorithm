package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B6497_Kruscal {
	static int[] father;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			father = new int[N];
			for (int i = 0; i < N; i++) {
				father[i] = i;
			}
			int total = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				pq.add(new Node(start, end, value));
				total += value;
			}
			int dist = 0;

			while (!pq.isEmpty()) {
				Node now = pq.poll();
				int startParent = findFather(now.start);
				int endParent =  findFather(now.end);
				if (startParent == endParent)
					continue;
				unionFather(startParent, endParent);
				dist += now.value;
			}
			System.out.println(total - dist);
		}
	}

	static int findFather(int a) {
		if (father[a] != a)
			return findFather(father[a]);
		else
			return a;
	}

	static void unionFather(int a, int b) {
		int aFather = findFather(a);
		int bFather = findFather(b);
		father[aFather] = bFather;
	}

	static class Node implements Comparable<Node> {
		int start, end, value;

		public Node(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

	}
}
