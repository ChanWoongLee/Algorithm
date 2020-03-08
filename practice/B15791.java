package practice;

import java.math.BigInteger;
import java.util.Scanner;

public class B15791 {
	static int dp[][];

	static int com(int n, int r) {
		if (r == 1)
			return n;
		if (n == r)
			return 1;

		if (dp[n - 1][r - 1] == 0)
			dp[n - 1][r - 1] = com(n - 1, r - 1)%1000000007;
	
		if (dp[n - 1][r] == 0)
			dp[n - 1][r] = com(n - 1, r)%1000000007;

		return (dp[n - 1][r - 1] + dp[n - 1][r]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int man = sc.nextInt();
		int fem = sc.nextInt();
		dp = new int[man+1][fem+1];
		System.out.println(com(man, fem));;
	}
}
