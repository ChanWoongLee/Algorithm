package LeetCode;

import java.util.Arrays;

public class L322 {

	public static void main(String[] args) {

	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = amount; j - coins[i] >= 0; j--) {
				if (dp[j - coins[i]] == -1)
					continue;
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		if(dp[amount] == 0)
			return -1;
					
		return dp[amount];
	}
}
