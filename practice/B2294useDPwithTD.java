package practice;

import java.util.Scanner;

public class B2294useDPwithTD {

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

		System.out.println(topDown(dp, money, k));
	}

	public static int topDown(int[] dp, int[] money, int k) {
		if(k==0) return 0;
		if(dp[k]!=0||dp[k]!=1) return dp[k]; //����  k�� ��������� �ּ�Ƚ���� 0��1 �̾ƴ� �� ����������� �װɷ�  ��ȯ
		int result = topDown(dp,money,k-1); // result k�� ��������� �� �ּ�Ƚ���� ���� �װ� dp�� ��Ƽ� ����ϴ°Ű�
		
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
