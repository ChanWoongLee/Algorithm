package practice;
import java.util.Scanner;

public class B10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len= sc.nextInt();
		int[][] dp = new int[101][10];
		int sum = 0;
		for(int i=1;i<10;i++)
			dp[1][i]=1;
		for(int l=2;l<=len;l++) {//길이 len까지 l증가
			for(int n=0;n<10;n++) {//숫자 0~9까지 가능한 경우의 수
				if(n==0)
					dp[l][n]=dp[l-1][1]%1000000000;
				else if(n==9)
					dp[l][n]=dp[l-1][8]%1000000000;
				else
					dp[l][n]=(dp[l-1][n-1]+dp[l-1][n+1])%1000000000;
			}
		}
		for(int n=0;n<10;n++)
			sum = (sum+dp[len][n])%1000000000;
		System.out.println(sum);
	}
}
