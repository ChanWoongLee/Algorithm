package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070 {
	static int[][] map;
	static int N;
	static int dr[] = { 0, 1, 1 };
	static int dc[] = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 1, 0));
	}

	static int dfs(int r, int c, int shape) {
		if (r == N - 1 && c == N - 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			if ((shape == 0 && i == 1) || (shape == 1 && i == 0))
				continue;
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || map[nextR][nextC] == 1)
				continue;
			if (i == 2 && (map[nextR - 1][nextC] == 1 || map[nextR][nextC - 1] == 1))
				continue;
			ans += dfs(nextR, nextC, i);
		}
		return ans;
	}
}
