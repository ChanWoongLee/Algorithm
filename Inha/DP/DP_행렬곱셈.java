package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DP_행렬곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (i == 0) {
				ar.add(a);
				ar.add(b);
			} else {
				ar.add(b);
			}
		}
		int[][] dp = new int[n + 1][n + 1]; // dp[i][j]의 의미 : i 번째 행렬부터 j 번째 행렬까지의 최소곱!!!
		// 11 22 33 ... / 12 23 34 45 56 67/ 13 24 ... / 1n 이 답!
		for (int differ = 1; differ <= n; differ++) {
			for (int i = 1; i + differ < n + 1; i++) {
				int j = differ + i;
				int save = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					save = Math.min(dp[i][k] + dp[k + 1][j] + ar.get(i - 1) * ar.get(k) * ar.get(j), save);
				}
				dp[i][j] = save;
			}
		}
		System.out.println(dp[1][n]);
	}

}
