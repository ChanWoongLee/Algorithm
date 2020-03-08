package practice;

import java.util.Scanner;

public class B11051useDP {
	static int[][] dp = new int[1001][1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			for (int k = 0; k <= i; k++) {
				if(k-1<0||i<0) dp[i][k]=1; 
				else {
					if(i==k) dp[i][k]=1;
					else if(k==0) dp[i][k]=1;
					else dp[i][k]=(dp[i-1][k-1]+dp[i-1][k])%10007;
				}
			}
		}
		System.out.println(dp[n][r]);
	}
}
