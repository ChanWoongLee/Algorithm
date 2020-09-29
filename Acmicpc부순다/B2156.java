package AcmicpcºÎ¼ø´Ù;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] podo = new int[n + 1];
		int[] dp = new int[n + 1];
		int[] cnt = new int[n + 1];
		cnt[1] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(bf.readLine());
			if (i - 2 > 0) {
				if (cnt[i - 1] <= 1) {
					if (dp[i - 1] + dp[i] >= dp[i - 2] + dp[i]) {
						cnt[i] = 2;
						dp[i] = dp[i - 1] + dp[i];
					} else {
						dp[i] = dp[i - 2] + dp[i];
						cnt[i] = 1;
					}
				} else if (cnt[i - 1] == 2) {
					if (dp[i - 1] >= dp[i - 2] + dp[i]) {
						cnt[i] = 0;
						dp[i] = dp[i - 1];
					} else {
						dp[i] = dp[i - 2] + dp[i];
						cnt[i] = 1;
					}
				}


			} else {
				dp[i] += dp[i - 1];
				cnt[i] = cnt[i - 1] + 1;
			}
		}
		System.out.println(dp[n]);
	}

}
