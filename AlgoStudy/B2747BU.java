package AlgoStudy;

import java.util.Scanner;

public class B2747BU {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] dp = new long [(int) (n+1)];
		dp[0] = 0; dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[(int) n]);
	}
}
