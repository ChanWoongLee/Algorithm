package practice;

import java.util.Scanner;

public class B2294useDPwithBU {

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
		for (int i = 0; i <= k; i++) {
			int min=k;
			if(dp[i]!=1) {
				for (int j = 0; j < n; j++) {
					if(i-money[j]>=0) {
						if(dp[i-money[j]]!=-1)
							min=Math.min(dp[i-money[j]]+1, min);
					}

				}
				if(min==k)
					min=-1;
				dp[i]=min;
			}
		}
		System.out.println(dp[k]);
	}

}
