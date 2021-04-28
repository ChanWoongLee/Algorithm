package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[T + 1][W + 2][3]; // 시간 움직인횟수 위치
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(bf.readLine());
			int now = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= W + 1; j++) {
				if (now == 1) {
					dp[i][j][1] = Math.max(dp[i - 1][j][1] + 1, dp[i - 1][j - 1][2] + 1);
					dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
				} else if (i == 1 && j == 1) {
					continue;
				} else {
					dp[i][j][2] = Math.max(dp[i - 1][j][2] + 1, dp[i - 1][j - 1][1] + 1);
					dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= W + 1; i++) {
			ans = Math.max(ans, Math.max(dp[T][i][1], dp[T][i][2]));
		}
		System.out.println(ans);
	}

}
