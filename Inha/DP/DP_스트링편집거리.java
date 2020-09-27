package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_스트링편집거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String original = bf.readLine();
		String target = bf.readLine();

		String[] str = bf.readLine().split(" ");
		int add = Integer.parseInt(str[0]);
		int del = Integer.parseInt(str[1]);
		int change = Integer.parseInt(str[2]);

		int[][] dp = new int[target.length() + 1][original.length() + 1];
		for (int i = 1; i < target.length() + 1; i++) {
			dp[i][0] = dp[i - 1][0] + del;
		}
		for (int i = 1; i < original.length() + 1; i++) {
			dp[0][i] = dp[0][i - 1] + add;
		}
		for (int i = 1; i < target.length() + 1; i++) {
			for (int j = 1; j < original.length()+1; j++) {
				int foradd = dp[i][j - 1] + add;
				int fordel = dp[i - 1][j] + del;
				int cost = change;
				if (original.charAt(j-1) == target.charAt(i-1))
					cost = 0;
				int forchange = dp[i - 1][j - 1] + cost;
				dp[i][j] = Math.min(fordel, Math.min(forchange, foradd));
			}
		}
		for(int i = 0; i < target.length()+1; i++) {
			for(int j = 0; j < original.length()+1;j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}System.out.println();
	}

}
