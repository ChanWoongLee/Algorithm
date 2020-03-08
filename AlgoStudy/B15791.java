package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B15791 {
	static long dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int man = Integer.parseInt(st.nextToken());
		int fem = Integer.parseInt(st.nextToken());
		dp = new long[man][fem];
		System.out.println(recur(man,fem));
	}

	static long recur(int n, int r) {
		if (r == 1)
			return n % 1000000007;
		if (n == r)
			return 1;
		if(dp[n][r]!= 0)
			return dp[n][r];
		
		return dp[n][r] = (recur(n - 1, r) % 1000000007 + recur(n - 1, r - 1) % 1000000007) % 1000000007;
	}
}
