package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class B17271 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[0] = 1;

		for (int i = 2; i < N + 1; i++) {
			if (i >= M)
				dp[i] = (dp[i - 1] + dp[i - M]) % 1000000007;
			else
				dp[i] = dp[i - 1];
		}
		System.out.println(dp[N]);
	}

}
