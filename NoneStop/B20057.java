package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20057 {
	// 12 : 02 Ω√¿€
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][] moveDr = { { -1, -2, -1, -1, 0, 1, 1, 1, 2, 0 }, { 2, -1, -1, 0, 0, 0, 0, 1, 1, 1 },
			{ -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 }, { -2, -1, -1, 0, 0, 0, 0, 1, 1, -1 } };
	static int[][] moveDc = { { 0, 0, -1, 1, -2, 0, -1, 1, 0, -1 }, { 0, -1, 1, -1, -2, 1, 2, -1, 1, 0 },
			{ 0, -1, 0, 1, 2, -1, 0, 1, 0, 1 }, { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 } };
	static int[][] move = { { 7, 2, 10, 1, 5, 7, 10, 1, 2, 1 }, { 5, 1, 1, 7, 2, 7, 2, 10, 10, 1 },
			{ 2, 1, 7, 10, 5, 1, 7, 10, 2, 1 }, { 5, 10, 10, 2, 7, 7, 2, 1, 1, 1 } };
	static int[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 4][N + 4];
		N = map.length;
		for (int i = 2; i < N - 2; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 2; j < N - 2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int nowR = N / 2;
		int nowC = N / 2;
		int dir = 0;
		int go = 1;
		boolean flag = true;
		while (flag) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < go; i++) {
					nowR += dr[dir];
					nowC += dc[dir];
					if (nowR == 2 && nowC == 1) {
						flag = false;
						break;
					}
					if (map[nowR][nowC] == 0)
						continue;
					int sand = map[nowR][nowC];
					int moveR, moveC, per, remain, moveSand;
					remain = sand;
					for (int m = 0; m < 9; m++) {
						moveR = nowR + moveDr[dir][m];
						moveC = nowC + moveDc[dir][m];
						per = move[dir][m];
						remain -= (sand * per) / 100;
						map[moveR][moveC] += (sand * per) / 100;
					}
					moveR = nowR + moveDr[dir][9];
					moveC = nowC + moveDc[dir][9];
					map[moveR][moveC] += remain;
					map[nowR][nowC] = 0;
				}
				if (!flag)
					break;
				dir++;
				dir %= 4;
			}
			go++;
		}
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sum += map[i][j];
			}
		}
		for (int i = 2; i < N - 2; i++) {
			for (int j = 2; j < N - 2; j++) {
				sum -= map[i][j];
			}
		}
		System.out.println(sum);
	}

}
