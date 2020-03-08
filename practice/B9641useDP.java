package practice;

import java.util.Scanner;

public class B9641useDP {
	static long[] dp = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int t= sc.nextInt();
		dp[1]=1; dp[2]=1; dp[3]=1; dp[4]=2; dp[5]=2;
		for (int i = 0; i < t; i++) {
			int  n= sc.nextInt();
			System.out.println(p(n));
		}
	}
	static long p(int n) {
		if(n<=5) return dp[n];
		if(dp[n]!=0) return dp[n];
		long result = p(n-1)+p(n-5);
		dp[n]=result;
		return dp[n];
		
	}
}
