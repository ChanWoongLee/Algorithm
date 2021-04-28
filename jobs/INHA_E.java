package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class INHA_E {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[3][N + 1];
		int[] dp = new int[N];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 4;
		for (int i = 2; i < N; i++) {
			for (int j = 0; j < 3; j++) {

			}
		}

	}

}
