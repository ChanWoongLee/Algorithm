package SummerCoding;

public class Programers_�Ž����� {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 }));
	}

	// ���� ���� ��� �ߺ��Ǵ� ��찡 �߻� dp �� Ȯ���ѵ� dp�� ��Ǯ������ dp�� �迭�� �÷� ������ �߰�����
	static public int solution(int n, int[] money) {
		int answer = 0;
		// dp[i] i���� ���� �� �ִ� ����Ǽ� -> dp[i][j] j���� ���� ������ i���� ���� �� �ִ� ����� ��
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
