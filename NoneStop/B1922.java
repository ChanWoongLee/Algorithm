package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1922 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] ar = new ArrayList[N + 1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			ar[start].add(new Node(end, value));
			ar[end].add(new Node(start, value));
		}
		int ans = 0;
		boolean[] visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (visit[i])
				continue;
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
			pq.add(new Node(i, 0));
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (visit[now.end])
					continue;
				visit[now.end] = true;
				ans += now.value;
				for (int j = 0; j < ar[now.end].size(); j++) {
					Node friend = ar[now.end].get(j);
					if (visit[friend.end])
						continue;
					pq.add(new Node(friend.end, friend.value));
				}
			}
		}
		System.out.println(ans);
	}

	static class Node {
		int end;
		int value;

		public Node(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

	}
}
