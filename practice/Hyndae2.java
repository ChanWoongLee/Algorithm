package practice;

public class Hyndae2 {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	static int result;

	static public int maxProfit(int[] prices) {
		result = 0;
		dfs(0, prices, 0, false, false);
		return result;
	}

	static void dfs(int index, int[] prices, int now, boolean have, boolean finish) {
		if (finish) {
			if (result < now)
				result = now;
			return;
		}
		if (index == prices.length) {
			return;
		}
		int money = prices[index];
		if (have == false) {
			dfs(index + 1, prices, now - money, true, false);
			dfs(index + 1, prices, now, false, false);
		} else {
			dfs(index + 1, prices, now + money, false, true);
			dfs(index + 1, prices, now, true, false);
		}
	}
}
