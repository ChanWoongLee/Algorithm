package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2458 {
	static int N;	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] ar = new ArrayList[N + 1];
		ArrayList<Integer>[] ar2 = new ArrayList[N + 1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < ar.length; i++) {
			ar2[i] = new ArrayList<>();
		}
		int[] indegree = new int[N + 1];
		int[] reverseDegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ar[start].add(end);
			ar2[end].add(start);
		}
		bfs(ar, indegree);
		bfs(ar2, reverseDegree);
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (indegree[i] + reverseDegree[i] == N - 1)
				ans++;
		}
		System.out.println(ans);
	}

	static void bfs(ArrayList<Integer>[] ar, int[] degree) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			boolean[] visit = new boolean[N + 1];
			int cnt = 0;
			q.add(i);
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < ar[now].size(); j++) {
					int friend = ar[now].get(j);
					if (visit[friend])
						continue;
					visit[friend] = true;
					cnt++;
					q.add(friend);
				}
			}
			degree[i] = cnt;
		}
	}
}
