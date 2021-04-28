package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1261 {
	static int[][] map;
	static int N, M;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		int[][] visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 0));
		visit[0][0] = 0;
		int ans = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Pos now = q.poll();
			if(ans <= now.cnt)
				continue;
			if(now.r == N-1 && now.c == M-1) {
				ans = Math.min(ans, now.cnt);
				continue;
			}
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];

				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
					continue;
				
				if (map[nextR][nextC] == 0) {
					if (visit[nextR][nextC] <= now.cnt)
						continue;
					visit[nextR][nextC] = now.cnt;
					q.add(new Pos(nextR, nextC, now.cnt));
				} else {
					if (visit[nextR][nextC] <= now.cnt+1)
						continue;
					visit[nextR][nextC] = now.cnt + 1;
					q.add(new Pos(nextR, nextC, now.cnt + 1));
				}
			}
		}
		System.out.println(ans);
	}

	static class Pos {
		int r, c;
		int cnt;

		public Pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
