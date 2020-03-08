package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 7
		pay[] fire = new pay[N + 1]; // 1 2 4 5 6 7
		int[] dp = new int[N + 2]; // 1 2 3 4 5 6 7 8
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			fire[i] = new pay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			if (max < dp[i - 1]) {
				max = dp[i - 1];
			} // max는 일 x 하고 이어온 돈
			if (dp[i] < max) {
				dp[i] = max;
			}
			if (i < fire.length && i + fire[i].day <= N + 1) {
				if (dp[fire[i].day + i] < dp[i] + fire[i].money)
					dp[fire[i].day + i] = dp[i] + fire[i].money;
			}
		}
		System.out.println(dp[N + 1]);
	}

	static class pay {
		int day;
		int money;

		public pay(int d, int m) {
			day = d;
			money = m;
		}
	}
}
