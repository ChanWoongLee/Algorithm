package practice;

import java.util.Scanner;

public class B10844useDPwithBU {
	static long[][] dp = new long[101][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			dp[1][i]=1;
		}
		for (int i = 2; i <=n; i++) {
			for (int j = 0; j <= 10; j++) {
				
			//	if(j==0) dp[i][j]= 
			}
		}
	}

}
