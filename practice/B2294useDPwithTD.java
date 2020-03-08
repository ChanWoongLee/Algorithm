package practice;

import java.util.Scanner;

public class B2294useDPwithTD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); //동전의 종류수
		int k=sc.nextInt(); // 더해서 찾고자 하는값
		int[] money = new int[n]; // 몇번째에 얼마하는동전 이란 걸위한 배열
		int[] dp = new int[k+1]; // 값들에 따른 최소값을 저장시키기 위한 배열
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			money[i]=m;
			if(m<=k) dp[m]=1;
		}

		System.out.println(topDown(dp, money, k));
	}

	public static int topDown(int[] dp, int[] money, int k) {
		if(k==0) return 0;
		if(dp[k]!=0||dp[k]!=1) return dp[k]; //만약  k가 만들어지는 최수횟수가 0과1 이아닌 즉 담겨져있으면 그걸로  반환
		int result = topDown(dp,money,k-1); // result k가 만들어지는 는 최소횟수를 뜻함 그걸 dp에 담아서 사용하는거고
		
		int min=10001;
		for (int j = 0; j < money.length; j++) {
			if(k-money[j]>=0) {
				if(dp[k-money[j]]!=-1)
					min=Math.min(dp[k-money[j]]+1, min);
			}

		}
		if(min==10001)
			min=-1;
		
		dp[k]=min;
		return min;
	}
}
