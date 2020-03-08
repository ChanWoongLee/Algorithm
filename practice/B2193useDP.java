package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B2193useDP {//use 메모이제이션 
	static long dp[]= new long[91];//dp[i] = i 자리수의 이친수는 몇개 인지 담아두는곳 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		int k=sc.nextInt();
		System.out.println(makeECS(k));
	}
	
	static long makeECS(int n) {
		long sum = 0;
		if (n==1 || n==2 || n==0)
			return 1;
		if (dp[n]!=0)
			return dp[n];
		
		
		for (int i = n-2; i >= 0; i--) {
			dp[n]+=makeECS(i);
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
