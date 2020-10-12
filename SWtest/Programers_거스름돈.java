package SummerCoding;

public class Programers_거스름돈 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 }));
	}

	// 돈에 따른 경우 중복되는 경우가 발생 dp 는 확실한데 dp로 안풀릴때는 dp의 배열을 늘려 조건을 추가하자
	static public int solution(int n, int[] money) {
		int answer = 0;
		// dp[i] i원을 만들 수 있는 경우의수 -> dp[i][j] j개의 동전 종류로 i원을 만들 수 있는 경우의 수
		// dp[i][j] = dp[i - money[j]][j-1];
		int[][] dp = new int[n + 1][money.length + 1];
		for (int i = 0; i < money.length; i++) {
			for (int j = 0; j < n + 1; j++) {
				if(j - money[i] > 0) {
					dp[j][i+1] = dp[j-money[i]][i];
				}else if(j - money[i] == 0) {
					
				}
			}
		}
		return dp[n][money.length - 1] % 1000000007;
	}
}
