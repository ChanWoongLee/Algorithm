package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {
	static int K, M, N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, 1 };
	static int[] hdr = { -2, -2, 2, 2, 1, -1, 1, -1 };
	static int[] hdc = { 1, -1, 1, -1, 2, 2, -2, -2 };

	static class Monky {
		int r, c, cnt, time;

		public Monky(int r, int c, int cnt, int time) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Monky start = new Monky(0, 0, 0, 0);
		boolean[][][] visit = new boolean[N][M][K + 1];

		visit[start.r][start.c][start.cnt] = true;
		Queue<Monky> q = new LinkedList<Monky>();
		q.add(start);
		while (!q.isEmpty()) {
			Monky now = q.poll();
			if (now.r == N - 1 && now.c == M - 1) {
				System.out.println(now.time);
				return;
			}
			for (int move = 0; move < dr.length; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
					continue;
				if (visit[nextR][nextC][now.cnt] || map[nextR][nextC] == 1)
					continue;
				q.add(new Monky(nextR, nextC, now.cnt, now.time + 1));
				visit[nextR][nextC][now.cnt] = true;
			}
			if (now.cnt == K)
				continue;
			for (int move = 0; move < hdr.length; move++) {
				int nextR = now.r + hdr[move];
				int nextC = now.c + hdc[move];
				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
					continue;
				if (visit[nextR][nextC][now.cnt + 1] || map[nextR][nextC] == 1)
					continue;
				q.add(new Monky(nextR, nextC, now.cnt + 1, now.time + 1));
				visit[nextR][nextC][now.cnt + 1] = true;
			}
		}
		System.out.println("-1");
	}

}
