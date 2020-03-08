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
	static long topdown(int n,int digit) {// 처음숫자가 digit일때 n높이의 계단수를 구할때!
		if(digit>=10) return 0;
		if(n==0) return 1; // digit 이  10이면  아무것도 못하지 
		if(digit==0) return topdown(n-1,digit+1)%1000000000;// base case 간의 순서의  중요성!
		if(dp[n][digit]!=0) return dp[n][digit];

		result=(topdown(n-1, digit-1)+topdown(n-1,digit+1))%1000000000;// 구하고자하는건  digit 1,2,3,4,5,6,7,8,9  더한거
		dp[n][digit]=result;
		return dp[n][digit];
	}
}
