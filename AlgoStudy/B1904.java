package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 00 = 2 , 1 = 1
// N 개의 타일 방법수 = (N - 1)개의 방법수 

public class B1904 {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dp = new int[N + 1][N + 1];

	}

}
