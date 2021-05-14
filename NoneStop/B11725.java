package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {
	static boolean[] visit;
	static int[] parentNode;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		parentNode = new int[n + 1];
		visit = new boolean[n + 1];
		visit[1] = true;
		dfs(1, 1);
		for (int i = 2; i < parentNode.length; i++) {
			System.out.println(parentNode[i]);
		}

	}

	static void dfs(int node, int prevNode) {
		if (node != 1) {
			visit[prevNode] = true;
			parentNode[node] = prevNode;
		}
		for (int i = 0; i < graph[node].size(); i++) {
			int now = graph[node].get(i);
			if (visit[now])
				continue;
			dfs(now, node);
		}
	}
}
