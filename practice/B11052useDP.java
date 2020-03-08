package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B11052useDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); 
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i]=sc.nextInt();
		}
		int[] dp = new int[n+1]; // n번째 동전부터 사용했을때 n+1 개의 최대가치 를저장 
		System.out.println(topDown(dp, p, 0, 0));
		System.out.println(Arrays.toString(dp));
		
	}
	static int topDown(int[] dp, int[]p, int n, int money) {// n번쨰부터 N번째 까지  
		if(n==p.length||money<=0) return money==0?0:-1;//-1의뜻은 만들수 없다.(-1은 impossible)
		if(dp[n]!=-1) return dp[n];
		int result = topDown(dp,p,n+1,money);
		if(money>=n) {
		result = Math.max(result, topDown(dp, p, n, money+p[n]));
		}

		dp[n]=result;
		money=p.length;
		System.out.println(result);
		return money;
	}
}
