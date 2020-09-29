package Acmicpc부순다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][W + 1];
		// dp[i][j]의 의미 : i번째 과일에 W만큼의 횟수 남은 자두가 먹을수있는 최대의 음식
		// 1인 것은 j 가 0 2 4 6
		// 2인것은 j 가 1 3 5 7
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(bf.readLine());
			for (int j = 0; j < W; j++) {

			}

		}
	}

}
