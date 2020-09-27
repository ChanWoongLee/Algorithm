package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2234 {
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] visit = new int[N][M];
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(0);
		int color = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] != 0)
					continue;
				int amount = bfs(i, j, color++, visit);
				ar.add(amount);
			}
		}
		System.out.println(color - 1);
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int move = 0; move < 4; move++) {
					if (i + dr[move] >= N || i + dr[move] < 0 || j + dc[move] >= M || j + dc[move] < 0)
						continue;
					if (visit[i][j] == visit[i + dr[move]][j + dc[move]])
						continue;
					max = max < ar.get(visit[i][j]) + ar.get(visit[i + dr[move]][j + dc[move]])
							? ar.get(visit[i][j]) + ar.get(visit[i + dr[move]][j + dc[move]])
							: max;
				}
			}
		}
		Collections.sort(ar, Collections.reverseOrder());
		System.out.println(ar.get(0));
		System.out.println(max);
	}

	static int bfs(int r, int c, int color, int[][] visit) {
		int cnt = 0;
		Queue<Castle> q = new LinkedList<Castle>();
		visit[r][c] = color;
		q.add(new Castle(r, c));
		while (!q.isEmpty()) {
			Castle now = q.poll();
			cnt++;
			int info = map[now.r][now.c];
			String str = Integer.toBinaryString(info);
			while (str.length() != 4) {
				str = "0" + str;
			}
			for (int i = 0; i < 4; i++) {
				if (str.charAt(i) == '0') {
					int nextR = now.r + dr[i];
					int nextC = now.c + dc[i];
					if (visit[nextR][nextC] == 0) {
						visit[nextR][nextC] = color;
						q.add(new Castle(nextR, nextC));
					}
				}
			}
		}
		return cnt;

	}
}

class Castle {
	int r, c;

	public Castle(int r, int c) {
		this.r = r;
		this.c = c;
	}
}