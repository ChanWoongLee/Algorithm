package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2 : 35  ½ÃÀÛ  1½Ã°£ÄÆ
public class B16988 {
	static int N, M;
	static int[][] map;
	static int[][] loc = new int[2][2];
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		johab(0, 0);
		System.out.println(result);
	}

	static void johab(int index, int cnt) {
		if (cnt == 2) {
			check();
			return;
		}
		if (index == N * M)
			return;
		int r = index / M;
		int c = index % M;
		if (map[r][c] != 0) {
			johab(index + 1, cnt);
			return;
		}
		loc[cnt][0] = r;
		loc[cnt][1] = c;
		johab(index + 1, cnt + 1);
		johab(index + 1, cnt);

	}

	static void check() {
		int[][] temp = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			temp[i] = Arrays.copyOf(map[i], M);
		}
		for (int i = 0; i < 2; i++) {
			int r = loc[i][0];
			int c = loc[i][1];
			temp[r][c] = 1;
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == false && temp[i][j] == 2) {
					int ret = bfs(i, j, temp);
					if (ret != -1)
						res += ret;
				}
			}
		}

//		if (result < res) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		result = result < res ? res : result;
	}

	static int bfs(int r, int c, int[][] temp) {
		Queue<baduk> q = new LinkedList();
		q.add(new baduk(r, c));
		visit[r][c] = true;
		int cnt = 1;
		boolean flag = false;
		while (!q.isEmpty()) {
			baduk now = q.poll();
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0 || visit[nextR][nextC])
					continue;
				if (temp[nextR][nextC] == 0)
					flag = true;
				if (temp[nextR][nextC] == 1)
					continue;
				cnt++;
				visit[nextR][nextC] = true;
				q.add(new baduk(nextR, nextC));
			}
		}
		if (flag)
			return -1;
		return cnt;
	}
}

class baduk {
	int r, c;

	public baduk(int r, int c) {
		this.r = r;
		this.c = c;
	}
}