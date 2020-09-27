package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class E_final {
	static int N, M, result, x, y;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			result = 0;

			Queue<Slim> q = new LinkedList();
			int day = 0;
			while (true) {
				int[][] tempMap = new int[N][M];
				for (int i = 0; i < N; i++)
					tempMap[i] = Arrays.copyOf(map[i], M);
				boolean change = false;
				boolean[][] visit = new boolean[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (visit[i][j])
							continue;
						ArrayList<Slim> combine = new ArrayList();
						Slim now = new Slim(i, j, tempMap[i][j]);
						combine.add(now);
						q.add(now);
						visit[now.r][now.c] = true;
						int amount = 0;
						int totalWeight = 0;
						while (!q.isEmpty()) {
							now = q.poll();
							amount++;
							totalWeight += now.weight;
							combine.add(now);
							for (int move = 0; move < 4; move++) {

								int nextR = now.r + dr[move];
								int nextC = now.c + dc[move];
								if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
									continue;
								if (visit[nextR][nextC])
									continue;
								if (!(Math.abs(tempMap[nextR][nextC] - tempMap[now.r][now.c]) >= x
										&& Math.abs(tempMap[nextR][nextC] - tempMap[now.r][now.c]) <= y))
									continue;
								visit[nextR][nextC] = true;
								change = true;
								q.add(new Slim(nextR, nextC, tempMap[nextR][nextC]));
							}
						}
						for (Slim s : combine) {
							map[s.r][s.c] = totalWeight / amount;
						}

					}
				}
				if (!change)
					break;
				day++;
				System.out.println(day);
			}
			System.out.println("#" + t + " " + day);
		}
	}

}

class Slim {
	int r, c, weight;

	public Slim(int r, int c, int weight) {
		this.r = r;
		this.c = c;
		this.weight = weight;
	}
}