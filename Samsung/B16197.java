package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16197 {
	// 7½Ã ½ÃÀÛ 40ºÐÄÆ Àú³á¸Ô¾Æ¾ßÂ¡
	static int N, M;
	static int result = Integer.MAX_VALUE;
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
		dfs();
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	static void dfs() {
		for (int i = 0; i < 4; i++) {
			int r1 = coin[0].r;
			int c1 = coin[0].c;
			int r2 = coin[1].r;
			int c2 = coin[1].c;
			int cnt1 = coin[0].cnt;
			int cnt2 = coin[1].cnt;
			if (cnt1 == 10)
				return;
			if(cnt1 >= result)
				return;
			int nextR1 = r1 + dr[i];
			int nextC1 = c1 + dc[i];
			int nextR2 = r2 + dr[i];
			int nextC2 = c2 + dc[i];
			if (drop(nextR1, nextC1) && drop(nextR2, nextC2))
				continue;
			if (drop(nextR1, nextC1) || drop(nextR2, nextC2)) {
				if (drop(nextR1, nextC1))
					result = result > coin[0].cnt + 1 ? coin[0].cnt + 1 : result;
				if (drop(nextR2, nextC2))
					result = result > coin[1].cnt + 1 ? coin[1].cnt + 1 : result;
				return;
			} // °ÔÀÓ³¡
			if (map[nextR1][nextC1].equals("#"))
				coin[0].cnt++;
			if (map[nextR2][nextC2].equals("#"))
				coin[1].cnt++;
			if (map[nextR1][nextC1].equals("."))
				coin[0] = new coin(nextR1, nextC1, cnt1 + 1);
			if (map[nextR2][nextC2].equals("."))
				coin[1] = new coin(nextR2, nextC2, cnt2 + 1);

			dfs();
			coin[0] = new coin(r1, c1, cnt1);
			coin[1] = new coin(r2, c2, cnt2);
		}
	}

	static boolean drop(int r, int c) {
		if (r >= N || r < 0 || c >= M || c < 0)
			return true;
		else
			return false;
	}
}

class coin {
	int r, c, cnt;

	public coin(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}