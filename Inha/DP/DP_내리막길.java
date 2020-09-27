package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_내리막길 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] home = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// int[][] dp = new int[N][M];
		// for (int i = 0; i < M; i++) {
		// dp[0][i] = home[0][i];
		// }
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					home[i][j] += (home[i - 1][j] < home[i - 1][j + 1] ? home[i - 1][j + 1] : home[i - 1][j]);
				} else if (j == M - 1) {w
					home[i][j] += (home[i - 1][j - 1] < home[i - 1][j] ? home[i - 1][j] : home[i - 1][j - 1]);
				} else {
					home[i][j] += (home[i - 1][j - 1] < home[i - 1][j]
							? home[i - 1][j] < home[i - 1][j + 1] ? home[i - 1][j + 1] : home[i - 1][j]
							: home[i - 1][j - 1] < home[i - 1][j + 1] ? home[i - 1][j + 1] : home[i - 1][j - 1]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < M; i++) {
			max = max < home[N - 1][i] ? home[N - 1][i] : max;
		}
		System.out.println(max);

	}

}
