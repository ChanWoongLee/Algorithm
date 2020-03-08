package AlgoStudy;

import java.util.Scanner;
// 48 분시작
public class B1005 {
	static int K;
	static int N;
	static int[] price;
	static boolean[][] connact;
	static int[][] dp; // 걸리는 최소시간을 저장
	static int goal;
	
	
	public static int recur(int s, int e) {
		if (s >= price.length) return 0;
		
		
		int minimum = -1;
		for(int i = e; i < price.length; i++) {
			int select = recur()
		}
		dp[s][e] = 
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			K = sc.nextInt();
			price = new int[N+1];
			for(int j = 1; j < price.length; j++) 
				price[j] = sc.nextInt();
			dp = new int[N+1][N+1];
			for(int j = 1; j < price.length; j++) {
				for(int k = 1; k < price.length; j++) {
					dp[j][k] = -1;
				}
			}
		connact = new boolean[N+1][N+1];
			for(int j = 0; j < K; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				connact[start][end] = true;
			}
			goal = sc.nextInt();
			
		}
	}
}
