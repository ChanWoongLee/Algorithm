package NoneStop;

public class P_µµµÏÁú {

	public static void main(String[] args) {
		solution(new int[] {1,2,3,1});
	}

	static public int solution(int[] money) {
		int answer = 0;
		int max = 0;
		int size = money.length;
		int[] dp = new int[size];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = money[i];
			for (int j = 0; j < i - 1; j++) {
				if (dp[i] < dp[j] + money[i]) {
					dp[i] = dp[j] + money[i];
					Math.max(dp[i], max);
				}
			}
		}
		
		return answer;
	}
}
