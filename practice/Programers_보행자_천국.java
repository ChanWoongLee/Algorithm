package practice;

import java.util.Arrays;

public class Programers_보행자_천국 {
	public static void main(String[] args) {
		System.out.println(
				solution(3, 6, new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } }));
	}

	static int MOD = 20170805;

	static public int solution(int m, int n, int[][] cityMap) {
		int[][] goRight = new int[m + 1][n + 1];
		int[][] goDown = new int[m + 1][n + 1];
		goDown[1][1] = 1;
		goRight[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1)
					continue;
				if (cityMap[i - 1][j - 1] == 0) {
					goDown[i][j] = goDown[i - 1][j] % MOD + goRight[i][j - 1] % MOD;
					goRight[i][j] = goDown[i - 1][j] % MOD + goRight[i][j - 1] % MOD;
				} else if (cityMap[i - 1][j - 1] == 2) {
					goDown[i][j] = goDown[i - 1][j];
					goRight[i][j] = goRight[i][j - 1];
				}
			}
		}
		return goDown[m][n] % MOD;
	}

}
