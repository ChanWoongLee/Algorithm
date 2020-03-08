package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5656 {
	// 12 : 03 Ω√¿€
	static int[][] map;
	static int[] t;
	static int result = Integer.MAX_VALUE;
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int ball = Integer.parseInt(st.nextToken());// N
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			map = new int[N][M];
			t = new int[4];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0, M, ball, map);

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int index, int cnt, int m, int ball, int[][] pan) {
		if (index == m)
			return;
		if (cnt == ball) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (pan[i][j] != 0)
						res++;
				}
			}
			result = result > res ? res : result;
			return;
		}


		
		for(int k = 0; k<m; k++) {
			t[cnt] = k;
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				temp[i] = Arrays.copyOf(pan[i], M);
			}
			for (int i = 0; i < N; i++) {
				if (pan[i][k] != 0) {
					boom(i, k, temp);
					break;
				}
			}

			down(temp);
			dfs(index, cnt + 1, m, ball, temp);
		}
	}

	static void down(int[][] temp) {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] != 0) {
					int c = i;
					while(true) {
						c++;
						if(c == N) {
							temp[c-1][j] = temp[i][j];
							temp[i][j] = 0;
							break;
						}
						if(temp[c][j]!=0) {
							if(c-1 == i)
								break;
							temp[c-1][j] = temp[i][j];
							temp[i][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	static void boom(int r, int c, int[][] temp) {
		boolean[][] visit = new boolean[N][M];
		visit[r][c] = true;
		Queue<sloc> q = new LinkedList();
		q.add(new sloc(r, c));
		visit[r][c] = true;
		while (!q.isEmpty()) {
			sloc now = q.poll();
			int nowr = now.r;
			int nowc = now.c;
			int len = temp[nowr][nowc] - 1;
			for (int move = 0; move < 4; move++) {
				int nextr = nowr;
				int nextc = nowc;
				for (int i = 0; i < len; i++) {
					nextr += dr[move];
					nextc += dc[move];
					if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M) {
						if (temp[nextr][nextc] != 0 && !visit[nextr][nextc]) {
							visit[nextr][nextc] = true;
							q.add(new sloc(nextr, nextc));
						}
					}
				}
			}
			temp[nowr][nowc] = 0;
		}
	}
}

class sloc {
	int r;
	int c;

	public sloc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
