package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17268 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		int[][] divide = new int[N + 1][N + 1];
		dp[2] = 1;
		dp[4] = 2;

		for (int i = 6; i <= N; i += 2) {
			for (int j = i - 2; j >= (i - 2) / 2; j -= 2) {
				if (j == i - 2)
					dp[i] += ((2% 987654321) * (dp[j]% 987654321)) % 987654321;
				else {
					if (j == i - j - 2)
						dp[i] += ((dp[j]% 987654321) * (dp[i - j - 2]% 987654321)) % 987654321;
					else
						dp[i] += ((2% 987654321) * (dp[j]% 987654321) * (dp[i - j - 2]% 987654321)) % 987654321;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
