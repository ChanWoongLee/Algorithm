package AcmicpcºÎ¼ø´Ù;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11060 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] jump = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(bf.readLine());
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			jump[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 1; i - j >= 0; j++) {
				if (jump[i - j] >= j && dp[i-j] != Integer.MAX_VALUE) {
					dp[i] = dp[i] > dp[i - j] + 1 ? dp[i - j] + 1 : dp[i];
				}
			}
		}
		if (dp[N - 1] == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(dp[N - 1]);
	}

}
