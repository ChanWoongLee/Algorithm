package AlgoStudy;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_triAngle {
	static int[][] triangle;
	static int[][] dp; // dp[a][b] a,b 칸까지의 최대합

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		while (testCase-- > 0) {
			int height = Integer.parseInt(bf.readLine());
			triangle = new int[height][height];
			dp = new int[height][height];
			for (int i = 0; i < height; i++) {
				String[] str = bf.readLine().split(" ");
				for (int j = 0; j <= i; j++) {
					triangle[i][j] = Integer.parseInt(str[j]);
				}
			}
			System.out.println(findMax(0, 0,height));
		}
	}

	static int findMax(int r, int c, int height) {
		if(r==height-1) 
			return triangle[r][c];
		if(dp[r][c] != 0)
			return dp[r][c];
		
		return dp[r][c] = Math.max(findMax(r+1, c, height), findMax(r+1, c+1, height)) + triangle[r][c];
	}

}
