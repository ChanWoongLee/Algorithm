package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForce2 {
	static int[][] dp;
	static int[] present;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int tcase = Integer.parseInt(st.nextToken());
		while (tcase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int n, p, k;
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			present = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < present.length; i++) {
				present[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[p + 1][n];
			System.out.println(dp(p,0));
		}
	}

	static int dp(int p, int n) {
		if (p == 0)
			return 0;
		
		boolean check = false;
		for(int i = 0; i< present.length; i++) {
			if(present[i] !=0 && present[i] < p)
				check = true;
		}
		if(check==false)
			return 0;
		
		if (dp[p][n] != 0)
			return dp[p][n];
		for (int i = 0; i < present.length; i++) {
			if (present[i] <= p && present[i] != 0) {
				int max = present[i];
				int nextmax_money = 0, nextmax_index = 0;
				present[i] = 0;
				for (int j = 0; j < present.length; j++) {
					if (nextmax_money > present[j] && present[j] <= max) {
						nextmax_money = present[j];
						nextmax_index = j;
					}
				}
				if (nextmax_money == 0) {
					return dp[p][i] = dp(p - nextmax_money, 0) + 1;
				} else {
					present[nextmax_index] = 0;
					return dp[p][i] = dp(p - nextmax_money, 0) + 2;
				}
			}

		}
		int result = 0;
		for(int i = 0; i < dp[p].length; i++)
			if(result < dp[p][i])
				result = dp[p][i];
		return result;
	}
}
