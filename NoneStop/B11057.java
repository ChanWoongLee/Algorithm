package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k >= 0; k--) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %=  10007;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 10; i++) {
			ans += dp[n-1][i]% 10007;
		}
		System.out.println(ans% 10007);
	}

}
