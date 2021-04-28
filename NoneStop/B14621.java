package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14621 {
	static int N, M;
	static String[] GENDER;
	static int[] dist;
	static boolean[] visit;
	static ArrayList<Node>[] graph;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		GENDER = new String[N];
		dist = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			GENDER[i] = st.nextToken();
		}
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, cost));
			graph[end].add(new Node(start, cost));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		int sum = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (visit[now.num])
				continue;
			visit[now.num] = true;
			sum += now.cost;

			String nowGender = GENDER[now.num];
			for (int i = 0; i < graph[now.num].size(); i++) {
				Node friend = graph[now.num].get(i);
				if (nowGender.equals(GENDER[friend.num]))
					continue;
				if (visit[friend.num])
					continue;
				q.add(friend);
			}

		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(sum);
	}

	static class Node implements Comparable<Node> {
		int num, cost;

		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}
