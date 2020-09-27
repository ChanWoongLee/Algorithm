package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1868 {
	// 7 : 41 ∫–Ω√¿€
	static int N;
	static String[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static boolean[] recur_visit;
	static boolean[][] visit;
	static int result;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split("");
		int test = Integer.parseInt(str[0]);
		for (int t = 1; t <= test; t++) {
			str = bf.readLine().split("");
			N = Integer.parseInt(str[0]);
			map = new String[N][N];
			total = 0;
			for (int i = 0; i < N; i++) {
				str = bf.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = str[j];
					if (map[i][j].equals("."))
						total++;
				}
			}
			result = Integer.MAX_VALUE;
			visit = new boolean[N][N];

			System.out.println("#" + t + " " + result);
		}
	}

	static Queue<Boom> bfs(int r, int c) {
		Boom start = new Boom(r, c);
		visit[r][c] = true;
		Queue<Boom> q = new LinkedList<Boom>();
		Queue<Boom> secure = new LinkedList<>();
		Queue<Boom> for_visit = new LinkedList<>();
		q.add(start);
		for_visit.add(start);
		while (!q.isEmpty()) {
			Boom now = q.poll();
			int fire = 0;
			for (int move = 0; move < 8; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
					continue;
				if (map[nextR][nextC].equals("*")) {
					fire++;
					continue;
				}
				if (visit[nextR][nextC])
					continue;
				secure.add(new Boom(nextR, nextC));
			}
			if (fire == 0) {
				for (Boom b : secure) {
					visit[b.r][b.c] = true;
					for_visit.add(b);
					q.add(b);
				}
				secure.clear();
			} else {
				visit[now.r][now.c] = true;
			}
		}
		return for_visit;
	}
}

class Boom {
	int r, c;

	public Boom(int r, int c) {
		this.r = r;
		this.c = c;
	}
}