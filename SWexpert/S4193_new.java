package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4193_new {
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
			for (int i = 0; i < N; i++)
				Arrays.fill(visit[i], Integer.MAX_VALUE);

			q.add(start);
			visit[start.r][start.c] = start.cnt;
			int time = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Swim now = q.poll();
					for (int move = 0; move < 4; move++) {
						int nextR = now.r + dr[move];
						int nextC = now.c + dc[move];
						if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
							continue;
						if (map[nextR][nextC] == 1)
							continue;
						if (map[nextR][nextC] == 2) {
							if (visit[nextR][nextC] <= now.cnt + (3 - time))
								continue;
							q.add(new Swim(nextR, nextC, now.cnt + (3 - time)));
							visit[nextR][nextC] = now.cnt + (3 - time);
							continue;
						}
						if (visit[nextR][nextC] <= now.cnt + 1)
							continue;
						visit[nextR][nextC] = now.cnt + 1;
						q.add(new Swim(nextR, nextC, now.cnt + 1));
					}
				}
				time++;
				if (time == 3)
					time = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (visit[i][j] == Integer.MAX_VALUE)
							System.out.print("0 ");
						else
							System.out.print(visit[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println("#" + t + " " + visit[end.r][end.c]);
		}
	}

}
//
//class Stom {
//	int r, c;
//
//	public Stom(int r, int c) {
//		this.r = r;
//		this.c = c;
//	}
//}
//
//class Swim {
//	int r, c, cnt;
//
//	public Swim(int r, int c, int cnt) {
//		this.r = r;
//		this.c = c;
//		this.cnt = cnt;
//	}
//}