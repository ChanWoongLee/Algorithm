package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_final {
	static int result, N;
	static int[][] map;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			result = 0;
			Man init = null;
			int enermy = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 9) {
						init = new Man(i, j, 2, 2);
						map[i][j] = 0;
					} else if (map[i][j] != 0)
						enermy++;
				}
			}
			Queue<Man> q = new LinkedList();
			q.add(init);
			boolean[][] visit = new boolean[N][N];
			visit[init.r][init.c] = true;
			int time = 0;
			while (true) {
				if (q.isEmpty() || enermy == 0)
					break;
				time++;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Man now = q.poll();
					for (int move = 0; move < 4; move++) {
						int nextR = now.r + dr[move];
						int nextC = now.c + dc[move];

						if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0)
							continue;
						if (map[nextR][nextC] > now.level)
							continue;
						if (visit[nextR][nextC])
							continue;

						if (map[nextR][nextC] <= now.level) {
							visit[nextR][nextC] = true;
							q.add(new Man(nextR, nextC, now.level, now.needs));
							continue;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (visit[i][j] && map[i][j] != 0 && map[i][j] < init.level) {// level 이 같을때, 0일때 (visit true,
																						// 이동만함)
							q.clear();
							if (init.needs - 1 == 0) {
								q.add(new Man(i, j, init.level + 1, init.level + 1));
								init = new Man(i, j, init.level + 1, init.level + 1);
							} else {
								q.add(new Man(i, j, init.level, init.needs - 1));
								init = new Man(i, j, init.level, init.needs - 1);
							}
							result += time;
							time = 0;
							visit = new boolean[N][N];
							visit[i][j] = true;
							enermy -= 1;
							map[i][j] = 0;
							i = N;
							j = N;
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}

class Man {
	int r, c, level, needs;

	public Man(int r, int c, int level, int needs) {
		this.r = r;
		this.c = c;
		this.needs = needs;
		this.level = level;
	}

}