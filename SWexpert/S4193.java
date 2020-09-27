package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4193 {
	// 2 시 47 분 시작!!!!
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ArrayList<Stom> s = new ArrayList();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2)
						s.add(new Stom(i, j));
				}
			}
			st = new StringTokenizer(bf.readLine());
			Swim start = new Swim(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(bf.readLine());
			Swim end = new Swim(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			Queue<Swim> q = new LinkedList();
			int[][] visit = new int[N][N];
			boolean[][] bvisit = new boolean[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(visit[i], Integer.MAX_VALUE);

			q.add(start);
			visit[start.r][start.c] = start.cnt;
			bvisit[start.r][start.c] = true;
			int time = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Swim now = q.poll();
					if (now.r == end.r && now.c == end.c) {
						result = now.cnt;
						q.clear();
						break;
					}
					for (int move = 0; move < 4; move++) {
						int nextR = now.r + dr[move];
						int nextC = now.c + dc[move];
						if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
							continue;
						if (map[nextR][nextC] == 1 || map[nextR][nextC] == 2) {
							continue;
						}
						if (bvisit[nextR][nextC])
							continue;
						bvisit[nextR][nextC] = true;
						q.add(new Swim(nextR, nextC, now.cnt + 1));
					}
					q.add(new Swim(now.r, now.c, now.cnt + 1));
				}
				time++;
				if (time >= 2) {
					if (time > 2)
						time = 0;
					for (Stom sto : s) {
						map[sto.r][sto.c] = map[sto.r][sto.c] == 2 ? 0 : 2;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}

class Stom {
	int r, c;

	public Stom(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Swim {
	int r, c, cnt;

	public Swim(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}