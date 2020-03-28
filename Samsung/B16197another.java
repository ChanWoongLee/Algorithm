package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16197another {
	static int N, M;
	static String[][] map;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static coin[] coin = new coin[2];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];

		int index = 0;
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("o")) {
					coin[index] = new coin(i, j, 0);
					index++;
					map[i][j] = ".";
				}
			}
		}

		Queue<coin> q = new LinkedList();
		q.add(coin[0]);
		q.add(coin[1]);
		while (!q.isEmpty()) {
			coin coin1 = q.poll();
			coin coin2 = q.poll();
			for (int i = 0; i < 4; i++) {
				int r1 = coin1.r;
				int c1 = coin1.c;
				int r2 = coin2.r;
				int c2 = coin2.c;
				int cnt1 = coin1.cnt;
				int cnt2 = coin2.cnt;
				if (cnt1 == 10) {
					System.out.println("-1");
					return;
				}
				int nextR1 = r1 + dr[i];
				int nextC1 = c1 + dc[i];
				int nextR2 = r2 + dr[i];
				int nextC2 = c2 + dc[i];
				if (drop(nextR1, nextC1) && drop(nextR2, nextC2))
					continue;
				if (drop(nextR1, nextC1) || drop(nextR2, nextC2)) {
						System.out.println(cnt1+ 1);
					return;
					// °ÔÀÓ³¡
				}
				if (map[nextR1][nextC1].equals("#"))
					q.add(new coin(r1, c1, cnt1 + 1));
				if (map[nextR1][nextC1].equals("."))
					q.add(new coin(nextR1, nextC1, cnt1 + 1));
				if (map[nextR2][nextC2].equals("#"))
					q.add(new coin(r2, c2, cnt2 + 1));
				if (map[nextR2][nextC2].equals("."))
					q.add(new coin(nextR2, nextC2, cnt2 + 1));
			}
		}
	}

	static boolean drop(int r, int c) {
		if (r >= N || r < 0 || c >= M || c < 0)
			return true;
		else
			return false;
	}
}
