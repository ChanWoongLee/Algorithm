package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573 {
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<Ice> q = new LinkedList();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					q.add(new Ice(i, j, map[i][j]));
			}
		}
		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			result++;
			int[][] tempMap = new int[N][M];
			for (int i = 0; i < N; i++)
				tempMap[i] = Arrays.copyOf(map[i], M);
			for (int i = 0; i < size; i++) {
				Ice now = q.poll();
				int water = 0;
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
						continue;
					if (map[nextR][nextC] == 0)
						water++;
				}
				if (now.h - water > 0) {
					q.add(new Ice(now.r, now.c, now.h - water));
					tempMap[now.r][now.c] = now.h - water;
				} else {
					tempMap[now.r][now.c] = 0;
				}
				// for (int ii = 0; ii < N; ii++) {
				// for (int j = 0; j < M; j++) {
				// System.out.print(tempMap[ii][j] + " ");
				// }
				// System.out.println();
				// }
				// System.out.println();
			}
			map = tempMap;
			boolean[][] visit = new boolean[N][M];
			boolean nothing = true;
			int island = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && visit[i][j] != true) {
						dfs(i, j, visit);
						island++;
						nothing = false;
					}
				}
			}

			if (nothing) {
				System.out.println("-1");
				return;
			}
			if (island >= 2) {
				System.out.println(result);
				return;
			}
		}
	}

	static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
				continue;
			if (map[nextR][nextC] == 0 || visit[nextR][nextC] == true) {
				continue;
			}
			dfs(nextR, nextC, visit);
		}
	}
}

class Ice {
	int r, c, h;

	public Ice(int r, int c, int h) {
		this.r = r;
		this.c = c;
		this.h = h;
	}
}
