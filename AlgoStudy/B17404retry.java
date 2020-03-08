package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404retry {
	static int[][] house;
	static int result = Integer.MAX_VALUE;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		house = new int[num][3];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[num][3];
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];

		for (int i = 0; i < num; i++) {
			for (int k = 0; k < 3; k++) {
				
			}
			for (int j = 0; j < 3; j++) {
				int color = j;
				color = color + 1 >= 3 ? (color + 1) % 3 : color + 1;
				int h1 = dp[i - 1][color];
				color = color + 1 >= 3 ? (color + 1) % 3 : color + 1;
				int h2 = dp[i - 1][color];
				dp[i][j] = Math.min(h1, h2) + house[i][j];
			}
		}

		System.out.println(result);
	}

}
