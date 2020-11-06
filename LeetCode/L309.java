package LeetCode;

public class L309 {

	public static void main(String[] args) {

	}

	static public int maxProfit(int[] prices) {
		// ��� �Ĵ� ����� ����츦 �����
		// ��°Ͱ� �Ĵ°��� �����Ǿ������ϱ� ����Ǹ鼭 ���θ� Ž��
		// ��°Ϳ����ؼ� ���������� ����ִ� ��� ��Ȳ�� ����ΰ�
		// �Ĵ°Ϳ� ���ؼ� ���������� �ȼ��ִ� ����Ȳ ����ΰ�
		// n�� ������ �����ذ� ������ ���⼭ �����̶� ����Ȳ�̾ƴ϶�
		// �춧 23456���� �����ʹ� �ʿ���ٴ� ���� ���� == ����� �������ϸ����ϴ�.
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
