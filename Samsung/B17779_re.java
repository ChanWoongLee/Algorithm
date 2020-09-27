package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17779_re {
	// 10 : 31
	static int N;
	static int[][] map;
	static int[] temp = new int[2];
	static int[] dr = { 1, 1 };
	static int[] dc = { -1, 1 };
	static int[] ddr = { -1, 1, 0, 0 };
	static int[] ddc = { 0, 0, -1, 1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0);
		System.out.println(result);
	}

	static void solve() {
		int d1 = temp[0];
		int d2 = temp[1];

		for (int i = 1; i <= N - d1 - d2; i++) {
			for (int j = 1 + d1; j <= N - d2; j++) {
				int[][] color = new int[N + 1][N + 1];
				fillandCal(i, j, d1, d2, color);
			}
		}
	}

	static void fillandCal(int r, int c, int d1, int d2, int[][] color) {
		for (int i = 1; i < r + d1; i++) {
			for (int j = 1; j <= c; j++) {
				color[i][j] = 1;
			}
		}
		for (int i = 1; i <= r + d2; i++) {
			for (int j = c + 1; j <= N; j++) {
				color[i][j] = 2;
			}
		}
		for (int i = r + d1; i <= N; i++) {
			for (int j = 1; j < c - d1 + d2; j++) {
				color[i][j] = 3;
			}
		}
		for (int i = r + d2 + 1; i <= N; i++) {
			for (int j = c - d1 + d2; j <= N; j++) {
				color[i][j] = 4;
			}
		}
		int nextR = r;
		int nextC = c;
		color[r][c] = 5;
		for (int i = 1; i <= d1; i++) {
			nextR += dr[0];
			nextC += dc[0];
			color[nextR][nextC] = 5;
		}
		for (int i = 1; i <= d2; i++) {
			nextR += dr[1];
			nextC += dc[1];
			color[nextR][nextC] = 5;
		}
		nextR = r;
		nextC = c;
		for (int i = 1; i <= d2; i++) {
			nextR += dr[1];
			nextC += dc[1];
			color[nextR][nextC] = 5;
		}
		for (int i = 1; i <= d1; i++) {
			nextR += dr[0];
			nextC += dc[0];
			color[nextR][nextC] = 5;
		}
		int[] value = new int[6];
		for (int i = 1; i <= N; i++) {
			boolean paint = false;
			for (int j = 1; j <= N; j++) {
				if (i == r && j == c)
					continue;
				if (i == r + d1 + d2 && j == c - d1 + d2)
					continue;
				if (color[i][j] == 5)
					paint = !paint;
				if (paint)
					color[i][j] = 5;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				value[color[i][j]] += map[i][j];
			}
		}
		Arrays.sort(value);
		int res = value[5] - value[1];

		result = result > res ? res : result;
	}

	static void recur(int cnt) {
		if (cnt == 2) {
			solve();
			return;
		}
		for (int i = 1; i <= N - 2; i++) {
			temp[cnt] = i;
			recur(cnt + 1);
		}
	}
}
