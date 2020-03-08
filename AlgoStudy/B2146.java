package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		boolean[][] mvisit = new boolean[N][N];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					Queue<loc> q = new LinkedList();
					q.add(new loc(i, j));
					map[i][j] = cnt;
					while (!q.isEmpty()) {
						loc nowl = q.poll();
						for (int k = 0; k < 4; k++) {
							int nextr = nowl.r + dr[k];
							int nextc = nowl.c + dc[k];
							if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && !mvisit[nextr][nextc]
									&& map[nextr][nextc] != 0) {
								q.add(new loc(nextr, nextc));
								mvisit[nowl.r][nowl.c] = true;
								map[nextr][nextc] = cnt;
							}
						}
					}
					cnt++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int[][] visit = new int[N][N];
					for (int k = 0; k < N; k++) {
						visit[k] = Arrays.copyOf(map[k], N);
					}
					Queue<loc> q = new LinkedList();
					q.add(new loc(i, j));
					int distance = 0;
					int nowisland = map[i][j];
					while (!q.isEmpty()) {
						if (result <= distance)
							break;
						int qsize = q.size();
						for (int index = 0; index < qsize; index++) {
							loc now = q.poll();
							for (int k = 0; k < 4; k++) {
								int nextr = now.r + dr[k];
								int nextc = now.c + dc[k];
								if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N) {
									if (visit[nextr][nextc] != nowisland && visit[nextr][nextc] > 0) {
										result = result > distance ? distance : result;
										q.clear();
										index = qsize;
										break;
									} else if (visit[nextr][nextc] == 0) {
										q.add(new loc(nextr, nextc));
										visit[nextr][nextc] = -1;
									}
								}
							}
						} // 한칸의 거리까지 추가
						distance++;
					}

				}
			}
		}
		System.out.println(result);

	}
}

class loc {
	int r, c;

	loc(int x, int y) {
		r = x;
		c = y;
	}
}
