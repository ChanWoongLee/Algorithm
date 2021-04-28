package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import NoneStop.B1922.Node;

public class B1922_2 {
	static int[] father;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		father = new int[N + 1];
		for (int i = 0; i < father.length; i++) {
			father[i] = i;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Node(start, end, value));
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (findFather(now.start) != findFather(now.end)) {
				ans += now.value;
				joinFather(now.start, now.end);
			}
		}
		System.out.println(ans);
	}

	static int findFather(int node) {
		if (father[node] == node)
			return node;
		return findFather(father[node]);
	}

	static void joinFather(int a, int b) {
		int aF = findFather(a);
		int bF = findFather(b);
		father[aF] = bF;
	}

	static class Node {
		int start;
		int end;
		int value;

		public Node(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

	}
}
