package AlgoStudy;

import java.util.Scanner;

public class B2579 {
	static int N;
	static int[] STAIR;
	static int[][] DP;
	public static int upStair(int x, int count) {
		if (x >= N) return 0;
		if (DP[x][count] != 0) return DP[x][count];
		int oneStep = 0, twoStep = 0;
		if ((x == N-2) && (count ==1)) return 0;
		if (count != 1)//count가 2가 아닐때만 실행하고  또는  x가 N-2일때 count가 1일땐  
			oneStep = upStair(x+1, count+1);
		twoStep = upStair(x+2, 0);
		DP[x][count] = Math.max(oneStep, twoStep) + STAIR[x];
		return DP[x][count];
		}
	// 문제의 핵심은 DP즉 메모이제이션이다. 처음에는 그 계단에서의 최대 값이 뛰는 방법에 따라 나눠져서 어떻게 사용할지 몰랐다.
	// 따라서 DP 또한 그 계단에서 뛴 방법에 따라 값을 나눠준다.      왜그런지 또 생각해보지 지금은 머리가아프다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		STAIR = new int[N];
		DP = new int[N][2]; // 
		for(int i = 0; i < N; i++) {
			STAIR[i] = sc.nextInt();
		}
		System.out.println(Math.max(upStair(0, 0), upStair(1, 0)));
	}

}
