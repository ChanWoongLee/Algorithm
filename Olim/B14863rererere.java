package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14863 {
	static int[] w_time;
	static int[] w_money;
	static int[] b_time;
	static int[] b_money;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		if (time == 0)
			System.exit(0);
		int[][] dp = new int[N + 1][time + 1];
		boolean[][] visit = new boolean[N + 1][time + 1];
		int[] w_time = new int[N];
		int[] w_money = new int[N];
		int[] b_time = new int[N];
		int[] b_money = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			w_time[i] = Integer.parseInt(st.nextToken());
			w_money[i] = Integer.parseInt(st.nextToken());
			b_time[i] = Integer.parseInt(st.nextToken());
			b_money[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= time; j++) {
				if(visit[i][j]) continue;
				if (j - w_time[i] >= 0 && j - b_time[i] >= 0) {
					dp[i + 1][j] = Math.max(dp[i][j - w_time[i]] + w_money[i], dp[i][j - b_time[i]] + b_money[i]);
					visit[i + 1][j] = true;
				} else if (j - w_time[i] >= 0) {
					dp[i + 1][j] = dp[i][j - w_time[i]] + w_money[i];
					visit[i + 1][j] = true;
				} else if (j - b_time[i] >= 0) {
					dp[i + 1][j] = dp[i][j - b_time[i]] + b_money[i];
					visit[i+1][j]=true;
				}
			}
		}
		int answer=0;
		for (int i = 0; i <= time; i++) {
            answer = Math.max(answer, dp[N][i]);
        }
		System.out.println(answer);
	}
}
