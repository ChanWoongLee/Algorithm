package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2115_re {
	static int N, M, C;
	static int[][] map;
	static int[][] worker;
	static boolean[] get;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			worker = new int[2][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			recur(0, 0, 0);
			System.out.println("#" + t + " " + result);
		}

	}

	static int select(int r, int c, int maxC, int sum, int square_sum) {
		if (sum > C)
			return -1;
		if (c == maxC)
			return square_sum;
		int get = select(r, c + 1, maxC, sum + map[r][c], square_sum + map[r][c] * map[r][c]);
		int not_get = select(r, c + 1, maxC, sum, square_sum);
		return Math.max(get, not_get);
	}// 
	 //

	static void recur(int index, int cnt, int sum) {
		if (cnt == 2) {
			result = result < sum ? sum : result;
			return;
		}
		if (index == N * N)
			return;

		for (int i = index; i < N * N; i++) {
			int r = i / N;
			int c = i % N;
			if (c + M - 1 >= N)
				continue;
			int res = select(r, c, c + M, 0, 0);
			// System.out.println(res);
			recur(i + M, cnt + 1, sum + res);
		}
	}
}
