package Acmicpc�μ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][W + 1];
		// dp[i][j]�� �ǹ� : i��° ���Ͽ� W��ŭ�� Ƚ�� ���� �ڵΰ� �������ִ� �ִ��� ����
		// 1�� ���� j �� 0 2 4 6
		// 2�ΰ��� j �� 1 3 5 7
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(bf.readLine());
			for (int j = 0; j < W; j++) {

			}

		}
	}

}
