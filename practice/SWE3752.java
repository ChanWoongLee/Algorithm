package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE3752 {
	static int[] grade;
	static boolean[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase =  Integer.parseInt(bf.readLine());
		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(bf.readLine());
			String[] g = bf.readLine().split(" ");
			grade = new int[g.length];
			dp = new boolean[100000];
			for (int j = 0; j < g.length; j++) {
				grade[j] = Integer.parseInt(g[j]);
			}
			dp[0] = true;
			int sum = 0;
			for (int k = 0; k < g.length; k++) {
				for (int j = 0; j <= sum; j++) {
					if (dp[j])
						dp[grade[k] + j] = true;
				}
				sum += grade[k];
			}
			int result = 0;
			for (int j = 0; j <= sum; j++)
				if (dp[i])
					result++;
			System.out.println("#" + (i + 1) + " " + result);
		}
	}

}
