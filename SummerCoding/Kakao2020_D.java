package SummerCoding;

import java.util.Arrays;

class Kakao2020_D {
	public static void main(String[] args) {

	}

	static int N, M;

	static public boolean solution(int[][] key, int[][] lock) {
		M = key.length;
		N = lock.length;

		int[][] bigMac = new int[N + M * 2][N + M * 2];
		for (int i = 0; i < bigMac.length; i++) {
			Arrays.fill(bigMac[i], 2);
		}
		for (int i = M; i <= M + N - 1; i++) {
			for (int j = M; j <= M + N - 1; j++) {
				bigMac[i][j] = lock[i - M][j - M];
			}
		}
		int bN = bigMac.length;
		for (int i = 0; i <= bN - M - 1; i++) {
			for (int j = 0; j <= bN - M - 1; j++) {
				int[][] tempbigMac = new int[N + M * 2][N + M * 2];
				for (int r = 0; r <= 4; r++) {
					rotate(key);
					for (int k = 0; k < bigMac.length; k++) {
						tempbigMac[k] = Arrays.copyOf(bigMac[k], bigMac.length);
					}
					if (solve(i, j, key, tempbigMac)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static public void rotate(int[][] key) {
		int[][] temp = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				int r = j;
				int c = (key.length - i - 1);
				temp[r][c] = key[i][j];
			}
		}

		for (int i = 0; i < key.length; i++) {
			key[i] = temp[i];
		}
	}

	static public boolean solve(int i, int j, int[][] key, int[][] bigMac) {
		for (int ii = i; ii < i + M; ii++) {
			for (int jj = j; jj < j + M; jj++) {
				if (bigMac[ii][jj] == 2)
					continue;
				if (bigMac[ii][jj] == 1 && key[ii - i][jj - j] == 1)
					return false;
				if (bigMac[ii][jj] == 0 && key[ii - i][jj - j] == 1)
					bigMac[ii][jj] = key[ii - i][jj - j];
			}
		}
		for (int k = M; k <= M + N - 1; k++) {
			for (int l = M; l <= M + N - 1; l++) {
				if (bigMac[k][l] == 0)
					return false;
			}
		}
		return true;
	}
}