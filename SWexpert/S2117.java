package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2117 {
	static int N, M, K;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());// N
			M = Integer.parseInt(st.nextToken());// M
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (N % 2 == 0)
				K = N + 2;
			else
				K = N;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int service = 1; service <= K; service++) {
						int service_money = service * service + (service - 1) * (service - 1);
						int home_money = 0;
						int res = 0;
						Queue<home> q = new LinkedList();
						boolean[][] visit = new boolean[N][N];
						q.add(new home(i, j, 1));
						visit[i][j] = true;
						while (!q.isEmpty()) {
							home now = q.poll();
							if (map[now.r][now.c] == 1) {
								res++;
								home_money += M;
							}
							if (now.cnt == service)
								continue;

							for (int move = 0; move < 4; move++) {
								int nextR = now.r + dr[move];
								int nextC = now.c + dc[move];
								if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
									continue;
								if (visit[nextR][nextC])
									continue;
								q.add(new home(nextR, nextC, now.cnt + 1));
								visit[nextR][nextC] = true;
							}
						}
						if (home_money - service_money >= 0)
							result = result < res ? res : result;
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

}

class home {
	int r, c, cnt;

	public home(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}