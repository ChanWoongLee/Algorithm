package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 00 = 2 , 1 = 1
// N ���� Ÿ�� ����� = (N - 1)���� ����� 

public class B1904 {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dp = new int[N + 1][N + 1];

	}

}
