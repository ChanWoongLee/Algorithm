package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split(" ");
			if (i == 0) {
				dp[0] = Integer.parseInt(str[0]);
				continue;
			}
			for (int j = i; j >= 0; j--) {
				int now = Integer.parseInt(str[j]);
				if (j == 0) {
					dp[0] += now;
				} else if (j == i) {
					dp[j] = dp[j - 1] + now;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]) + now;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}

}
