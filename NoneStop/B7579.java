package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] mem = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		int[] cost = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[100000];
		dp[cost[0]] = mem[0];
		for (int i = 1; i < cost.length; i++) {
			for (int j = 0; j <= 10000; j++) {
				if (dp[j] != 0) {
					if (j + cost[i] > 10000)
						continue;
					dp[j + cost[i]] = Math.max(dp[j] + mem[i], dp[j + cost[i]]);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 10000; i++) {
			if (dp[i] >= M) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

}
