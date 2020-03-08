package AlgoStudy;

import java.util.Scanner;

public class B1003BU {
	static int[][] dp = new int[41][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		dp[0][0] = 1; dp[0][2] = 1;
		dp[1][1] = 1; dp[1][2] = 1;
		
		for(int t = 0; t < testCase; t++) {
			int n = sc.nextInt();
			if(dp[n][2] == 0) {
				for(int i = 2; i <= n; i++) {
					dp[i][2] = 1;
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
					dp[i][0] = dp[i-1][0] + dp[i-2][0];
				}
				System.out.println(dp[n][0] + " " + dp[n][1]);
			}
			else {
				System.out.println(dp[n][0] + " " + dp[n][1]);
			}
		}
	}
}
