package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18808retry {
	static int N, M, K;
	static int[][] map;
	static int[][][] stiker;
	static int[][] stikerNM;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		stiker = new int[K][12][12];
		stikerNM = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			stikerNM[i][0] = r;
			stikerNM[i][1] = c;
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < c; k++) {
					stiker[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		dfs(0);
		System.out.println(result);
	}

	static void dfs(int index) {
		if (index == K) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0)
						res++;
				}
			}
			result = res;
			return;
		}
		for (int i = 0; i < 4; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (check(r, c, index)) {
						dfs(index + 1);
						return;
					}
				}
			}
			rotate(index);
		}
		dfs(index + 1);
		return;

	}

	static void rotate(int index) {
		int r = stikerNM[index][0];
		int c = stikerNM[index][1];
		int[][] temp = new int[12][12];
		for (int i = 0; i < 12; i++) {
			temp[i] = Arrays.copyOf(stiker[index][i], 12);
		}
		stiker[index] = new int[12][12];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				stiker[index][i][j] = temp[r - 1 - j][i];
			}
		}
		stikerNM[index][0] = c;
		stikerNM[index][1] = r;
	}

	static boolean check(int initR, int initC, int index) {
		int r = stikerNM[index][0];
		int c = stikerNM[index][1];

		if (initR + r > N || initC + c > M)
			return false;
		for (int i = initR; i < initR + r; i++) {
			for (int j = initC; j < initC + c; j++) {
				if (map[i][j] != 0 && stiker[index][i - initR][j - initC] != 0)
					return false;
			}
		}
		for (int i = initR; i < initR + r; i++) {
			for (int j = initC; j < initC + c; j++) {
				if (stiker[index][i - initR][j - initC] == 0 || map[i][j] != 0)
					continue;
				map[i][j] = stiker[index][i - initR][j - initC];
			}
		}
		return true;
	}
}
