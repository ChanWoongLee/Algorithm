package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B11066 {
	static int[] book;
	static int[][] dp;
	static int[] booksum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		while (testcase-- > 0) {
			int chapter = Integer.parseInt(bf.readLine());
			book = new int[chapter+1];
			booksum = new int[chapter + 1];
			dp = new int[chapter + 1][chapter + 1];
			String[] str = bf.readLine().split(" ");
			for(int[] a : dp) {
				Arrays.fill(a, -1);
			}
			for (int i = 1; i <= chapter; i++) {
				book[i] = Integer.parseInt(str[i-1]);
				booksum[i] = book[i] + booksum[i-1];
			}
			System.out.println(sum(1, chapter));
		}
	}

	// 합 값은 필요없음
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!부분의 최소만
	public static int sum(int start, int end) {
		if (start == end)
			return dp[start][end] = 0;
		if (start == end - 1)
			return dp[start][end] = book[start] + book[start + 1];

		if (dp[start][end] != -1)
			return dp[start][end];

		
		dp[start][end] = 987654321;
		int mid = start;
		for (int i = mid; i < end; i++) {
			dp[start][end] = Math.min(dp[start][end],
					sum(start, mid) + sum(mid + 1, end) + booksum[end] - booksum[start-1]);
		}
		return dp[start][end];
	}
}
