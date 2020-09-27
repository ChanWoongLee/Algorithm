package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {
	// 11 : 22 Ω√¿€
	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j, 0, visit);
			}
		}
		System.out.println(result + 1);
	}

	static void dfs(int r, int c, int cnt, int[][] visit) {
		if (visit[r][c] != 0 && visit[r][c] > cnt)
			return;

		visit[r][c] = cnt;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
				continue;
			if (visit[nextR][nextC] > cnt + 1)
				continue;
			if (map[nextR][nextC] <= map[r][c])
				continue;
			dfs(nextR, nextC, cnt + 1, visit);
		}
		if (result < cnt)
			result = cnt;
	}
}
