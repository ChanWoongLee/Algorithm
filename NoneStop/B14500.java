package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int[][] map;
	static int N, M, ans = 0;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 0, map[i][j]);
				visit[i][j] = false;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt, int score) {
		if (cnt == 3) {
			ans = Math.max(score, ans);
			return;
		}

		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
				continue;
			if (visit[nextR][nextC])
				continue;
			visit[nextR][nextC] = true;
			dfs(nextR, nextC, cnt + 1, score + map[nextR][nextC]);
			visit[nextR][nextC] = false;
		}
	}

}
