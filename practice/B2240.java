package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[T + 1][W + 1];
		// dp[T][W] 는 T초 이후에 W움직엿을때 먹을 수 있는 자두의 최대개수.
		// 상황에 대한 모든 결과를 종합하자
		for (int i = 0; i <= T; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0] = 0;
		dp[0][1] = 0;
		int result = 0;
	
		System.out.println(result);
	}

}
