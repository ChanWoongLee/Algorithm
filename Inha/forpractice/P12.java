package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int Batt = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] minus = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				minus[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][M];
		dp[0][0] = Batt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i - 1 < 0) {
					int now = dp[i][j - 1] - minus[i][j];
					if (now < 0) {
						dp[i][j] = -1;
					} else if (now >= 0) {
						int save = now + map[i][j];
						if (save >= Batt)
							dp[i][j] = Batt;
						else
							dp[i][j] = save;
					}
				} else if (j - 1 < 0) {
					int now = dp[i - 1][j] - minus[i][j];
					if (now < 0) {
						dp[i][j] = -1;
					} else if (now >= 0) {
						int save = now + map[i][j];
						if (save >= Batt)
							dp[i][j] = Batt;
						else
							dp[i][j] = save;
					}
				} else {
					int one = dp[i - 1][j] - minus[i][j];
					int two = dp[i][j - 1] - minus[i][j];
					int three = (int) (dp[i - 1][j - 1] - (1.4 * minus[i][j]));
					int max = Math.max(one, Math.max(two, three));
					if (max < 0)
						dp[i][j] = -1;
					else {
						int save = max + map[i][j];
						if (save >= Batt)
							dp[i][j] = Batt;
						else
							dp[i][j] = save;
					}
				}
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}

}
