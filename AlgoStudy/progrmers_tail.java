package AlgoStudy;

public class progrmers_tail {
	public static void main(String[] args) {
		int N = 5;
		class Solution {
		    public long solution(int N) {
				int dp[] = new int[N+1];
				dp[0] = 1;
				dp[1] = 1;
				for (int i = 2; i < dp.length; i++) {
					dp[i] = dp[i-1] + dp[i-2];
				}
				long answer = (dp[N]+dp[N-1])*2 + dp[N]*2;
		        return answer;
		    }
		}
	}

}
