package AlgoStudy;

import java.math.BigInteger;
import java.util.Scanner;

public class B2749 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] dp = new long [(int) (n+1)];
		dp[0] = 0; dp[1] = 1;
		머르겠다
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[(int) n]);
	}
}
