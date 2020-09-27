package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> coin = new ArrayList<>();
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {

			int nowCoin = Integer.parseInt(bf.readLine());
			if (nowCoin == k) {
				System.out.println("1");
				return;
			} else if (nowCoin < k) {
				dp[nowCoin] = 1;
				coin.add(nowCoin);
			}
		}

		for (int i = 1; i <= k; i++) {
			if (dp[i] == 0)
				continue;
			for (int c : coin) {
				if (i + c <= k) {
					if (dp[i + c] == 0)
						dp[i + c] = dp[i] + 1;
					else
						dp[i + c] = dp[i] + 1 > dp[i + c] ? dp[i + c] : dp[i] + 1;
				}
			}
		}

		if (dp[k] == 0)
			System.out.println("-1");
		else
			System.out.println(dp[k]);
	}

}
