package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] home = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][3];
		dp[0][0] = home[0][0];
		dp[0][1] = home[0][1];
		dp[0][2] = home[0][2];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][j];
				else if (j == 1)
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][j];
				else
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][j];
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = min > dp[N - 1][i] ? dp[N - 1][i] : min;
		}
		System.out.println(min);
	}

}
