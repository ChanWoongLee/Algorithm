package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;
	static int N;

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
		boolean[][] mvisit = new boolean[N][N];
		int color = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || mvisit[i][j])
					continue;
				dfs(i, j, color, mvisit);
				color++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				mvisit = new boolean[N][N];
				Queue<loc> q = new LinkedList();
				q.add(new loc(i, j, 0));
				mvisit[i][j] = true;
				while (!q.isEmpty()) {
					loc now = q.poll();
					if (now.cnt >= result)
						break;
					for (int move = 0; move < 4; move++) {
						int nextR = now.r + dr[move];
						int nextC = now.c + dc[move];
						if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
							continue;
						if (mvisit[nextR][nextC] || map[i][j] == map[nextR][nextC])
							continue;
						mvisit[nextR][nextC] = true;
						q.add(new loc(nextR, nextC, now.cnt + 1));
						if (map[nextR][nextC] != 0) {
							result = now.cnt;
							q.clear();
							break;
						}
					}
				}
			}
		}
		System.out.println(result);

	}

	static void dfs(int r, int c, int color, boolean[][] mvisit) {
		mvisit[r][c] = true;
		map[r][c] = color;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				continue;
			if (mvisit[nextR][nextC] || map[nextR][nextC] == 0)
				continue;
			dfs(nextR, nextC, color, mvisit);
		}

	}
}

class loc {
	int r, c, cnt;

	loc(int x, int y, int cnt) {
		r = x;
		c = y;
		this.cnt = cnt;
	}
}
