package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_최적이진트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		float[] p = new float[n + 1];
		st = new StringTokenizer(bf.readLine());
		float[][] dp = new float[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			p[i] = Float.parseFloat(st.nextToken());
			dp[i][i] = p[i];
		}
		for (int differ = 1; differ <= n; differ++) {
			for (int i = 1; i + differ < n + 1; i++) {
				int j = differ + i;
				float save = Integer.MAX_VALUE;
				float sum = 0;
				for (int s = i; s <= j; s++)
					sum += p[s];
				for (int k = i; k <= j; k++) {
					save = Math.min(dp[i][k - 1] + dp[k + 1][j] + sum, save);
				}
				dp[i][j] = save;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
// 4
// 0.1 0.2 0.3 0.4