package AlgoStudy;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

public class B2407biginteger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger dp[][] = new BigInteger[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			for(int k = 0; k <= i; k++) {
				if(k == 0) dp[i][k] = BigInteger.valueOf(1);
				else if (i == 1) dp[i][k] = BigInteger.valueOf(1);
				else if (i == k) dp[i][k] = BigInteger.valueOf(1);
				else {
					dp[i][k] = dp[i-1][k-1].add(dp[i-1][k]);
					if ((i == n) && (k == m)) break;
				}
			}
		}
		System.out.println(dp[n][m].divide(BigInteger.valueOf(1000000007)));
	}
}
