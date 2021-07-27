package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 2; j * j <= i; j++) {
				if (i - j * j >= 0)
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[n]);
	}

}
