package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2105_re {
	static int[][] map;
	static int result;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int N;
	static int[] temp;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = -1;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());// N
			map = new int[N][N];
			temp = new int[2];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recur(0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static void solve(int r, int c) {
		visit = new boolean[101];
		int len = 0;
		int res = 0;
		for (int move = 0; move < 4; move++) {
			if (move == 0 || move == 2)
				len = temp[0];
			else
				len = temp[1];
			for (int i = 0; i < len; i++) {
				r += dr[move];
				c += dc[move];
				if (r >= N || c >= N || r < 0 || c < 0)
					return;
				if (visit[map[r][c]])
					return;
				visit[map[r][c]] = true;
				res++;
			}
		}
		result = result < res ? res : result;
	}

	static void recur(int cnt) {
		if (cnt == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i + temp[0] + temp[1] < N)
						solve(i, j);
				}
			}
			return;
		}
		for (int i = 1; i < N - 1; i++) {
			temp[cnt] = i;
			recur(cnt + 1);
		}
	}
}
