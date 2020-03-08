package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2096 {
	static int[][] loca;
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		loca = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				loca[i][j] = Integer.parseInt(str[j]);
				dp[i][j] = -1;
			}
		}
		int max = Math.max(maxPoint(0, 0), maxPoint(0, 1));
		max = Math.max(max, maxPoint(0, 2));
		System.out.print(max+" ");
		
		dp = new int[N][3];
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < 3; j++) {
				dp[i][j] = -1;
			}
		}
		int min= Math.min(minPoint(0, 0), minPoint(0, 1));
		min = Math.min(min, minPoint(0, 2));
		System.out.print(min);
	}

	static int maxPoint(int x, int y) {
		if (x == N - 1)
			return loca[x][y];

		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		if (y == 0) {
			dp[x][y] = Math.max(maxPoint(x + 1, y) + loca[x][y], maxPoint(x + 1, y + 1) + loca[x][y]);
		} else if (y == 2) {
			dp[x][y] = Math.max(maxPoint(x + 1, y) + loca[x][y], maxPoint(x + 1, y - 1) + loca[x][y]);
		} else {
			dp[x][y] = Math.max(maxPoint(x + 1, y) + loca[x][y], maxPoint(x + 1, y + 1) + loca[x][y]);
			dp[x][y] = Math.max(dp[x][y], maxPoint(x + 1, y - 1) + loca[x][y]);
		}

		return dp[x][y];
	}
	
	static int minPoint(int x, int y) {
		if (x == N - 1)
			return loca[x][y];

		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		if (y == 0) {
			dp[x][y] = Math.min(minPoint(x + 1, y) + loca[x][y], minPoint(x + 1, y + 1) + loca[x][y]);
		} else if (y == 2) {
			dp[x][y] = Math.min(minPoint(x + 1, y) + loca[x][y], minPoint(x + 1, y - 1) + loca[x][y]);
		} else {
			dp[x][y] = Math.min(minPoint(x + 1, y) + loca[x][y], minPoint(x + 1, y + 1) + loca[x][y]);
			dp[x][y] = Math.min(dp[x][y], minPoint(x + 1, y - 1) + loca[x][y]);
		}

		return dp[x][y];
	}
}
