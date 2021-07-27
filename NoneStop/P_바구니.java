package NoneStop;

import java.util.Arrays;

public class P_¹Ù±¸´Ï {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}

	public static int solution(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (dp[i - j * j] + 1 < dp[i])
					dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		return dp[n];
	}
}
