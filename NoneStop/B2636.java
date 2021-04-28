package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2636 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static ArrayList<Pos> temp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 1;
		int remain = 0;
		while (true) {
			visit = new boolean[N][M];
			temp = new ArrayList<>();
			dfs(0, 0);
			int removeCnt = 0;
			boolean Cheese = false;
			for (Pos p : temp) {
				map[p.r][p.c] = -1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
						removeCnt++;
					} else if (map[i][j] == 1)
						Cheese = true;
				}
			}
			if (Cheese == false) {
				remain = removeCnt;
				break;
			}
			time++;
		}
		System.out.println(time);
		System.out.println(remain);
	}

	static void dfs(int r, int c) {
		visit[r][c] = true;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0)
				continue;
			if (visit[nextR][nextC])
				continue;
			if (map[nextR][nextC] == 1) {
				temp.add(new Pos(nextR, nextC));
				continue;
			}
			dfs(nextR, nextC);

		}
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
