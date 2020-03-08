package AlgoStudy;

import java.util.Scanner;

public class B2747TD {
	static int[] dp;
	public static int topDown(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (dp[n] != -1) return dp[n];
		dp[n] = topDown(n-1) + topDown(n-2);
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int [n+1];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(topDown(n));
	}
}
