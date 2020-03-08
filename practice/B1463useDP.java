package practice;

import java.util.Scanner;

public class B1463useDP {
	static int dp[]= new int[1000001];//dp[i] = i�� 1�� ��������� Ƚ�� !!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int count=0;
//		for (int i = 2; i <= k; i++) {//���Ҿ� �����
//			dp[i]=dp[i-1]+1;// ������ 1�÷����غ��� �ִ��� �״ϱ�
//			if(i%2==0 && (dp[i/2]+1)<dp[i])//�ȵǸ� 2�� �������� 0�̴� �׸��� i�� 1���ѰŴϱ� ũ�� �ϸ�
//				dp[i]=dp[i/2]+1;//dp[i] �� 2�γ��� �ſ� +1
//			if(i%3==0 && (dp[i/3]+1<dp[i]))//3����������
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
