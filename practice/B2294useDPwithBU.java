package practice;

import java.util.Scanner;

public class B2294useDPwithBU {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); //������ ������
		int k=sc.nextInt(); // ���ؼ� ã���� �ϴ°�
		int[] money = new int[n]; // ���°�� ���ϴµ��� �̶� ������ �迭
		int[] dp = new int[k+1]; // ���鿡 ���� �ּҰ��� �����Ű�� ���� �迭
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
