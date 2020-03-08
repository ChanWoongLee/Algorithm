package AlgoStudy;

import java.util.Scanner;

public class B1932 {
	static int N;
	static int[][] triangle;
	static int[][] DP;
	public static int triSum(int x, int y) {
		if(x >= N) return 0;
		if(DP[x][y] != -1)  return DP[x][y]; 
		DP[x][y] = Math.max(triSum(x+1, y), triSum(x+1, y+1)) + triangle[x][y] ;
		return DP[x][y];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		triangle = new int[N][N];
		DP = new int[N][N];
		for(int i = 0; i < DP.length; i++) {
			for(int k=0; k < DP.length; k++)
				DP[i][k] = -1;
		}
		for(int i = 0; i < N; i++) {
			for(int k = 0; k <= i; k++) {
				triangle[i][k] = sc.nextInt();
			}
		}
		System.out.println(triSum(0, 0));
	}

}
