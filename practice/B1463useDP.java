package practice;

import java.util.Scanner;

public class B1463useDP {
	static int dp[]= new int[1000001];//dp[i] = i를 1로 만들기위한 횟수 !!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int count=0;
//		for (int i = 2; i <= k; i++) {//바텀업 방법임
//			dp[i]=dp[i-1]+1;// 다음꺼 1플러스해보고 최대지 그니까
//			if(i%2==0 && (dp[i/2]+1)<dp[i])//안되면 2로 나눳을때 0이다 그리고 i가 1더한거니까 크다 하면
//				dp[i]=dp[i/2]+1;//dp[i] 는 2로나는 거에 +1
//			if(i%3==0 && (dp[i/3]+1<dp[i]))//3도마찬가지
//				dp[i]=dp[i/3]+1;
//		}
		System.out.println(makeOneCount(k));
	}
	static int makeOneCount(int n) {
		if(n==0)
			return 0;
		if (dp[n]!=0) {
			return dp[n];
		}
		dp[n]=makeOneCount(n-1)+1;
		
		if(n%3==0 && dp[n/3]+1<dp[n]) {
			dp[n]=dp[n/3]+1;
			return 0;
		}
		else if(n%2==0 && dp[n/2]+1<dp[n]) {
			dp[n]=dp[n/2]+1;
			return 0;
		}
		
		return dp[n];
	}
}
