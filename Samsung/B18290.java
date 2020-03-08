package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class B18290 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MIN_VALUE;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}

	static void dfs(int index, int cnt, int sum) {
		if (cnt == K) {
			result = sum > result ? sum : result;
			return;
		}
		if (index >= map.length * map[0].length)
			return;

		int r = index / map[0].length;
		int c = index % map[0].length;

		if (visit[r][c] == true) {
			dfs(index + 1, cnt, sum);
			return;
		}
		boolean go = true;

		for (int j = 0; j < 4; j++) {
			int ar = r + dr[j];
			int ac = c + dc[j];
			if (ar >= 0 && ar < map.length && ac >= 0 && ac < map[0].length) {
				if (visit[ar][ac] == true)
					go = false;
			}
		}
		if (go) {
			visit[r][c] = true;
			dfs(index + 1, cnt + 1, sum + map[r][c]);
			visit[r][c] = false;
			dfs(index + 1, cnt, sum);
		} else
			dfs(index + 1, cnt, sum);
	}
}
