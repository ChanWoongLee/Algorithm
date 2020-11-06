package LeetCode;

public class L309 {

	public static void main(String[] args) {

	}

	static public int maxProfit(int[] prices) {
		// 사고 파는 경우의 모든경우를 잰거임
		// 사는것과 파는것은 연관되어있으니까 진행되면서 서로를 탐색
		// 사는것에대해서 독립적으로 살수있는 모든 상황을 적어두고
		// 파는것에 대해서 독립적으로 팔수있는 모든상황 적어두고
		// n번 돌리면 최적해가 구해줌 여기서 최적이란 모든상황이아니라
		// 살때 23456일전 데이터는 필요없다는 말씀 최적 == 모든경우 라고생각하면편하다.
		if (prices.length < 2)
			return 0;
		int[][] dp = new int[2][prices.length + 1];
		dp[1][0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp[0][i] = Math.max(dp[1][i - 1] + prices[i], dp[0][i - 1]);
			dp[1][i] = Math.max((i - 2 >= 0 ? dp[0][i - 2] : dp[0][i - 1]) - prices[i], dp[1][i - 1]);
		}
		return dp[0][prices.length - 1];

	}
}
