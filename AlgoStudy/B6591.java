package AlgoStudy;
import java.math.BigInteger;
import java.util.Scanner;

public class B6591 {
	static BigInteger dp[][];
	
	public static BigInteger combination(int n, int k) {
		if(n == k)
			return BigInteger.valueOf(1);
		if(k == 0) 
			return BigInteger.valueOf(1);
		if(dp[n][k] != null)
			return dp[n][k];
		dp[n][k] = combination(n-1, k-1).add(combination(n-1, k));
		return dp[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new BigInteger[1000000][1000000];
		while(true) {
		int N = sc.nextInt();
		int K = sc.nextInt();
		if ((N == 0) && (K == 0)) break;
		System.out.println(combination(N, K));
		}
	}

}
