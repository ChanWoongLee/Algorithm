package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B11052useDPwithBU {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); 
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i]=sc.nextInt();
			dp[i]=0;
			for (int j = 1; j <=i; j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+p[j]);
				System.out.println(Arrays.toString(dp));
			}
		}
		System.out.println(dp[n]);
	}

}
