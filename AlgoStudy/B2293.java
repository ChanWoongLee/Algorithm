package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2293 {
	static int N;
	static int goal;
	static int[] coin;
	static int[] dp; // 동적계획벅 기본은 완전탐색!!
	// dp[i][j]의 의미 i번째 동전까지 탐색한뒤 j원이 될 경우의수
	// dp[i][j] += dp[i-1][j - coin[i]]

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
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= goal; j++) {
				dp[j] += dp[ j - coin[i]];
			}
		}
		System.out.println(dp[goal]);
	}
}