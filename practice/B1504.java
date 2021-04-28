package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {
	static ArrayList<Node>[] ar;
	static int N;
	static boolean impossible;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		impossible = false;
		ar = new ArrayList[N + 1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			ar[start].add(new Node(end, value));
			ar[end].add(new Node(start, value));
		}
		st = new StringTokenizer(bf.readLine());
		int dest1 = Integer.parseInt(st.nextToken());
		int dest2 = Integer.parseInt(st.nextToken());
		int final_dest = N;
		int[][] one_route = { { 1, dest1 }, { dest1, dest2 }, { dest2, N } };
		int[][] two_route = { { 1, dest2 }, { dest2, dest1 }, { dest1, N } };
		int result = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += findDijk(one_route[i][0], one_route[i][1]);
		}
		if (!impossible)
			result = sum;
		sum = 0;
		impossible = false;
		for (int i = 0; i < 3; i++) {
			sum += findDijk(two_route[i][0], two_route[i][1]);
		}
		List<List<Integer>> res = new LinkedList<>();
		res.con
		if (!impossible)
			result = Math.min(sum, result);
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static public long findDijk(int start, int end) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int i = 0; i < ar[now.node].size(); i++) {
				Node friend = ar[now.node].get(i);
				if (dist[friend.node] > friend.value + now.value) {
					dist[friend.node] = friend.value + now.value;
					pq.add(new Node(friend.node, dist[friend.node]));
				}
			}
		}
		if (dist[end] == Integer.MAX_VALUE)
			impossible = true;

		return dist[end];
	}

	static class Node implements Comparable<Node> {
		int node;
		long value;

		public Node(int node, long dist) {
			this.node = node;
			this.value = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.value, o.value);
		}
	}
}
