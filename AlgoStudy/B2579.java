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
		if (count != 1)//count�� 2�� �ƴҶ��� �����ϰ�  �Ǵ�  x�� N-2�϶� count�� 1�϶�  
			oneStep = upStair(x+1, count+1);
		twoStep = upStair(x+2, 0);
		DP[x][count] = Math.max(oneStep, twoStep) + STAIR[x];
		return DP[x][count];
		}
	// ������ �ٽ��� DP�� �޸������̼��̴�. ó������ �� ��ܿ����� �ִ� ���� �ٴ� ����� ���� �������� ��� ������� ������.
	// ���� DP ���� �� ��ܿ��� �� ����� ���� ���� �����ش�.      �ֱ׷��� �� �����غ��� ������ �Ӹ���������
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
