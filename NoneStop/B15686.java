package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15686 {
	static int[][] map;
	static int customerCnt = 0;
	static ArrayList<Chiken> chiken;
	static ArrayList<Chiken> choice;
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ANSWER = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chiken = new ArrayList<>();
		choice = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					customerCnt++;
				else if (map[i][j] == 2) {
					chiken.add(new Chiken(i, j));
				}
			}
		}

		recur(0, 0);
		System.out.println(ANSWER);
	}

	static void recur(int index, int cnt) {
		if (cnt == M) {
			boolean[][] visit = new boolean[N][N];
			Queue<Chiken> q = new LinkedList<>();
			for (Chiken c : choice) {
				q.add(c);
				visit[c.r][c.c] = true;
			}
			int nowCnt = 0;
			int nowSum = 0;
			int dir = 1;
			while (!q.isEmpty()) {
				int qSize = q.size();
				for (int i = 0; i < qSize; i++) {
					Chiken c = q.poll();
					for (int move = 0; move < 4; move++) {
						int nextR = c.r + dr[move];
						int nextC = c.c + dc[move];
						if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
							continue;
						if (visit[nextR][nextC])
							continue;
						if (map[nextR][nextC] == 1) {
							nowCnt++;
							nowSum += dir;
						}
						if (nowCnt == customerCnt) {
							ANSWER = Math.min(ANSWER, nowSum);
							return;
						}
						visit[nextR][nextC] = true;
						q.add(new Chiken(nextR, nextC));
					}
				}
				dir++;
			}

			return;
		}

		for (int i = index; i < chiken.size(); i++) {
			choice.add(chiken.get(i));
			recur(i + 1, cnt + 1);
			choice.remove(choice.size() - 1);
		}

	}

	static class Chiken {
		int r, c;

		public Chiken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
