package AlgoStudy;

import java.util.Scanner;

public class B1149 {
	static int N;
	static int[][] RGB;
	static int[][] DP;
	public static int color(int x, int y) {
		if(x >= N) return 0;
		if(DP[x][y] != 0) return DP[x][y]; 
		int result = 0;
		if (y == 0)
			result = Math.min(color(x+1 , 1), color(x+1 , 2));
		else if (y == 1)
			result = Math.min(color(x+1 , 0), color(x+1 , 2));
		else
			result = Math.min(color(x+1 , 0), color(x+1 , 1));
		DP[x][y] = result + RGB[x][y];
		return DP[x][y];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		RGB = new int[N][3];
		DP = new int[N][3]; // 색깔의 값은 자연수이고 계속 더하므로 0은 나오지 않는다.
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < 3; i++) {
				RGB[k][i] = sc.nextInt();
			}
		}
		System.out.println(Math.min(Math.min(color(0 , 0), color(0 , 1)), color(0, 2)));
	}

}
