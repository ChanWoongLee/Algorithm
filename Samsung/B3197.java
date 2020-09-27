package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3197 {
	// 8 ½Ã 50 ºÐ
	static int N, M;
	static String[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Duck> toRemove;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		ArrayList<Duck> init = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("L"))
					init.add(new Duck(i, j));

			}
		}
		int day = 0;
		while (!meet(init)) {
			day++;
			boolean[][] visit = new boolean[N][M];
			toRemove = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visit[i][j] || map[i][j].equals("."))
						continue;
					bfs(i, j, visit);
				}
			}
			while (!toRemove.isEmpty()) {
				Duck now = toRemove.poll();
				map[now.r][now.c] = ".";
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(day);
	}

	static void bfs(int r, int c, boolean[][] visit) {
		Queue<Duck> q = new LinkedList<Duck>();
		q.add(new Duck(r, c));
		visit[r][c] = true;
		while (!q.isEmpty()) {
			Duck now = q.poll();
			boolean remove = true;
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (!check(nextR, nextC) || visit[nextR][nextC])
					continue;
				if (map[nextR][nextC].equals(".") && remove) {
					toRemove.add(new Duck(now.r, now.c));
					remove = false;
					continue;
				}
				visit[nextR][nextC] = true;
				q.add(new Duck(nextR, nextC));
			}
		}
	}

	static boolean meet(ArrayList<Duck> init) {
		Duck start = init.get(0);
		Duck end = init.get(1);
		boolean[][] visit = new boolean[N][M];
		visit[start.r][start.c] = true;
		Queue<Duck> q = new LinkedList<Duck>();
		q.add(start);
		while (!q.isEmpty()) {
			Duck now = q.poll();
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (end.r == nextR && end.c == nextC)
					return true;
				if (!check(nextR, nextC))
					continue;
				if (visit[nextR][nextC])
					continue;
				if (map[nextR][nextC].equals("X"))
					continue;
				q.add(new Duck(nextR, nextC));
				visit[nextR][nextC] = true;
			}
		}
		return false;
	}

	static boolean check(int r, int c) {
		if (r >= N || r < 0 || c >= M || c < 0)
			return false;
		return true;
	}
}

class Duck {
	int r, c;

	public Duck(int r, int c) {
		this.r = r;
		this.c = c;
	}
}