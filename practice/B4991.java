package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4991 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			String[][] map = new String[N][M];
			Pos machine = null;
			int hudle = 0;
			for (int i = 0; i < N; i++) {
				String[] str = bf.readLine().split("");
				for (int j = 0; j < M; j++) {
					map[i][j] = str[j];
					if (map[i][j].equals("o"))
						machine = new Pos(i, j, 0);
					else if (map[i][j].equals("*"))
						hudle++;
				}
			}
			int result = 0;
			int cnt = 0;
			Queue<Pos> q = new LinkedList<Pos>();
			q.add(machine);
			boolean[][] visit = new boolean[N][M];
			visit[machine.r][machine.c] = true;
			while (!q.isEmpty()) {
				if (cnt == hudle)
					break;
				Pos now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
						continue;
					if (map[nextR][nextC].equals("x") || visit[nextR][nextC])
						continue;

					if (map[nextR][nextC].equals("*")) {
						result += now.move + 1;
						q.clear();
						visit = new boolean[N][M];
						q.add(new Pos(nextR, nextC, 0));
						visit[nextR][nextC] = true;
						cnt++;
						break;
					}
					visit[nextR][nextC] = true;
					q.add(new Pos(nextR, nextC, now.move + 1));
				}
			}
			if (result == 0)
				System.out.println("-1");
			else
				System.out.println(result);
		}
	}

	static class Pos {
		int r, c;
		int move;

		public Pos(int r, int c, int move) {
			this.r = r;
			this.c = c;
			this.move = move;
		}
	}
}
