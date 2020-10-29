package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


import practice.B1197_use_PRIM.Node;

public class B1197_use_KRUSKAL {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] ar = new ArrayList[V + 1];
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<Node>();
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Node(start, end, value));
		}
		int answer = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int startParent = find(now.start);
			int endParent = find(now.end);
			if(startParent == endParent)
				continue;
			union(startParent,endParent);
			answer+=now.value;
		}
		System.out.println(answer);
	}

	static int find(int node) {
		if (parent[node] == node)
			return parent[node];

		return find(parent[node]);
	}

	static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		parent[aParent] = bParent;

	}

	static class Node implements Comparable<Node> {
		int start, end, value;

		public Node(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		public int compareTo(Node other) {
			return this.value - other.value;
		}
	}

}
