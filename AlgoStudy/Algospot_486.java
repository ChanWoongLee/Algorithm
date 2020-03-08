package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algospot_486 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split("");
		N = Integer.parseInt(str[0]);
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + 2 * dp[i - 2];
		}

		if (N % 2 == 1) {
			System.out.println(dp[N] - dp[N / 2]);
		} else {
			int result;
			if (N >= 6)
				result = dp[N] - 2 * dp[(N - 2) / 2] - dp[N / 2];
			else
				result = dp[N] -dp[N / 2];

			System.out.println(result);
		}

	}

}
