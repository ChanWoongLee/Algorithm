package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import NoneStop.B1167.Node;

public class B9466 {
	static int[] graph;
	static int[] visit;
	static int ans = 0;
	static int[] originStart;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			graph = new int[n + 1];
			visit = new int[n + 1];
			originStart = new int[n + 1];
			st = new StringTokenizer(bf.readLine());
			int same = 0;
			for (int i = 1; i <= n; i++) {
				graph[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int start = 1; start <= n; start++) {
				if (visit[start] != 0)
					continue;
				ans += dfs(start, start, 1);
			}
			System.out.println(n - ans - same);
		}
	}

	static int dfs(int origin, int node, int depth) {
		visit[node] = depth;
		originStart[node] = origin;

		int next = graph[node];
		if (visit[next] != 0) {
			if (origin == originStart[next]) {
				return depth - visit[next] +1;
			}else
				return 0;
		}
		return dfs(origin, next, depth + 1);
	}
}
