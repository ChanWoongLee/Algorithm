package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_final {
	static int result, N, M, K;
	static ArrayList<difuse> d;
	static boolean[] select;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			result = Integer.MAX_VALUE;
			d = new ArrayList();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						d.add(new difuse(i, j, 0));
						map[i][j] = 0;
					}
				}
			}
			select = new boolean[d.size()];
			dfs(0, 0);
			if (result == Integer.MAX_VALUE)
				result = -1;
			System.out.println("#" + t + " " + result);
		}
	}

	static void dfs(int n, int cnt) {
		if (cnt == K) {
			int res = solve();
			result = res < result ? res : result;
			return;
		}

		if (n == d.size())
			return;

		select[n] = true;
		dfs(n + 1, cnt + 1);
		select[n] = false;
		dfs(n + 1, cnt);
	}

	static int solve() {
		Queue<difuse> q = new LinkedList();
		// boolean[][] visit = new boolean[N][M];
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++)
			temp[i] = Arrays.copyOf(map[i], M);

		for (int i = 0; i < select.length; i++) {
			if (select[i]) {
				q.add(d.get(i));
				temp[d.get(i).r][d.get(i).c] = 1;
			}
		}

		while (!q.isEmpty()) {
			difuse now = q.poll();
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
					continue;
				if (temp[nextR][nextC] != 0)
					continue;

				temp[nextR][nextC] = now.time + 1;
				q.add(new difuse(nextR, nextC, now.time + 1));
			}
		}

		boolean complete = true;
		for (difuse a : d) {
			temp[a.r][a.c] = -1;
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					continue;
				if (temp[i][j] == 0)
					complete = false;
				res = temp[i][j] > res ? temp[i][j] : res;
			}
		}
		if (complete)
			return res;
		else
			return Integer.MAX_VALUE;
	}
}

class difuse {
	int r, c, time;

	public difuse(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}
}
