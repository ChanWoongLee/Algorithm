package practice;
import java.util.Scanner;

public class B10844useDP {
	static long result = 0;
	static long[][] dp = new long[101][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long res=0;
		for (int i = 1; i <=9; i++) {
			res+=topdown(n-1, i);
			result=0;
		}
		System.out.println(res%1000000000);
	}
	static long topdown(int n,int digit) {// ó�����ڰ� digit�϶� n������ ��ܼ��� ���Ҷ�!
		if(digit>=10) return 0;
		if(n==0) return 1; // digit ��  10�̸�  �ƹ��͵� ������ 
		if(digit==0) return topdown(n-1,digit+1)%1000000000;// base case ���� ������  �߿伺!
		if(dp[n][digit]!=0) return dp[n][digit];

		result=(topdown(n-1, digit-1)+topdown(n-1,digit+1))%1000000000;// ���ϰ����ϴ°�  digit 1,2,3,4,5,6,7,8,9  ���Ѱ�
		dp[n][digit]=result;
		return dp[n][digit];
	}
}
