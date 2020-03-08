package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2249 {
	static int N;
	static int goal;
	static int[] coin;
	static int[] dp; // 값은 동전의 최소 개수
	//

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		coin = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[goal + 1];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= goal; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		if (dp[goal] == 987654321)
			System.out.println("-1");
		else
			System.out.println(dp[goal]);
	}
}
