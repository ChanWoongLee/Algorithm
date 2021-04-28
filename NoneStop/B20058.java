package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B20058 {
	// 3:37 Ω√¿€
	static int N, Q;
	static int[][] map;
	static int mapLen;
	static int[] rotate;
	static int[][] temp;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		rotate = new int[Q];
		mapLen = map.length;
		temp = new int[mapLen][mapLen];
		for (int i = 0; i < mapLen; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < mapLen; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < Q; i++) {
			rotate[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < rotate.length; i++) {
			int L = rotate[i];
			int part;
			if (L == 0)
				part = mapLen;
			else
				part = (int) Math.pow(2, L);
			for (int r = 0; r < mapLen; r += part) {
				for (int c = 0; c < mapLen; c += part) {
					turn(r, c, part);
				}
			}

			for (int r = 0; r < mapLen; r++) {
				for (int c = 0; c < mapLen; c++) {
					map[r][c] = temp[r][c];
				}
			}
			ArrayList<Pos> ar = new ArrayList<>();
			for (int r = 0; r < mapLen; r++) {
				for (int c = 0; c < mapLen; c++) {
					if(map[r][c] ==0)
						continue;
					int iceCnt = 0;
					for (int move = 0; move < 4; move++) {
						int nextR = r + dr[move];
						int nextC = c + dc[move];
						if (nextR < 0 || nextR >= mapLen || nextC < 0 || nextC >= mapLen)
							continue;
						if (map[nextR][nextC] == 0)
							continue;
						iceCnt++;
					}
					if (iceCnt < 3)
						ar.add(new Pos(r, c));
				}
			}
			for (Pos p : ar) {
				map[p.r][p.c]--;
			}
		}
		visit = new boolean[mapLen][mapLen];
		int max = 0;
		int sum = 0;
		for (int r = 0; r < mapLen; r++) {
			for (int c = 0; c < mapLen; c++) {
				sum += map[r][c];
				if (visit[r][c] || map[r][c] == 0)
					continue;
				max = Math.max(max, dfs(r, c));
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static void minus(int r, int c) {
		map[r][c]--;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR < 0 || nextR >= mapLen || nextC < 0 || nextR >= mapLen)
				continue;
			if (visit[nextR][nextC] || map[nextR][nextC] == 0)
				continue;
			minus(nextR, nextC);
		}
	}

	static int dfs(int r, int c) {
		int cnt = 1;
		visit[r][c] = true;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR < 0 || nextR >= mapLen || nextC < 0 || nextC >= mapLen)
				continue;
			if (visit[nextR][nextC] || map[nextR][nextC] == 0)
				continue;
			cnt += dfs(nextR, nextC);
		}
		return cnt;
	}

	static void turn(int startR, int startC, int size) {
		int rotateR = startR;
		int rotateC = startC + size;

		for (int r = startR; r < startR + size; r++) {
			rotateC -= 1;
			rotateR = startR;
			for (int c = startC; c < startC + size; c++) {
				temp[rotateR++][rotateC] = map[r][c];
			}
		}

	}
}
