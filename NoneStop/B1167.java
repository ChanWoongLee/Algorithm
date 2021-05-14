package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1167 {
	static ArrayList<Node>[] graph;
	static boolean[] visit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		int[] cnt = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			while (true) {
				int end = Integer.parseInt(st.nextToken());
				if (end == -1)
					break;
				int value = Integer.parseInt(st.nextToken());
				graph[start].add(new Node(end, value));
				cnt[end]++;
			}
		}
		for (int root = 1; root <= n; root++) {
			visit[root] = true;
			dfs(root, 0);
			visit[root] = false;
		}
		System.out.println(ans);
	}

	static void dfs(int root, int sum) {
		for (int i = 0; i < graph[root].size(); i++) {
			Node now = graph[root].get(i);
			if (visit[now.node])
				continue;
			visit[now.node] = true;
			dfs(now.node, sum + now.value);
			visit[now.node] = false;
		}
		ans = Math.max(sum, ans);
	}

	static class Node {
		int node, value;

		public Node(int node, int value) {
			super();
			this.node = node;
			this.value = value;
		}

	}

}
