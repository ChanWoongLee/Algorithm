package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17136retry {
	static int[][] map = new int[10][10];
	static int result = Integer.MAX_VALUE;
	static int[] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper = new int[5];
		for (int i = 0; i < 5; i++) {
			paper[i] = 6;
		}
		dfs(0, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	static void dfs(int index, int cnt) {
		if (index == 100) {
			result = cnt < result ? cnt : result;
			return;
		}
		if (cnt > result)
			return;

		int nowr = index / 10;
		int nowc = index % 10;
		if (map[nowr][nowc] == 1) {
			for (int i = 4; i >= 0; i--) {
				if (checkfill(nowr, nowc, i) && paper[i] != 1) {
					fill(nowr, nowc, i, 0);
					paper[i]--;
					dfs(index + 1, cnt + 1);
					paper[i]++;
					fill(nowr, nowc, i, 1);
				}
			}
		} else {
			dfs(index + 1, cnt);
		}
	}

	static void fill(int r, int c, int i, int v) {
		for (int a = r; a <= r + i; a++) {
			for (int b = c; b <= c + i; b++) {
				map[a][b] = v;
			}
		}
	}

	static boolean checkfill(int r, int c, int i) {
		for (int a = r; a <= r + i; a++) {
			for (int b = c; b <= c + i; b++) {
				if (a >= 10 || b >= 10 || map[a][b] != 1)
					return false;
			}
		}
		return true;
	}
}
