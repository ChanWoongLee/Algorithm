package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11066Re {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] num = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j + i < n; j++) {
					if (j == i + j) {
						dp[j][j + i] = num[j];
					} else {
						dp[j][j + i] = Math.min(dp[j + 1][j + i] + num[j], dp[j][j + i - 1] + num[j + i]);
					}
				}
			}
		}
	}

}
