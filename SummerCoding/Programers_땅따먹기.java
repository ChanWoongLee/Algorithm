package SummerCoding;

import java.util.Arrays;

public class Programers_¶¥µû¸Ô±â {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
	}

		static int solution(int[][] land) {
			int answer = 0;
			int[][] dp = new int[land.length][land[0].length];
			for (int i = 0; i < land.length; i++) {
				dp[i] = Arrays.copyOf(land[i], land[0].length);
			}
	
			for (int row = 1; row < land.length; row++) {
				for (int col = 0; col < land[0].length; col++) {
					for (int upCol = 0; upCol < land[0].length; upCol++) {
						if (col == upCol)
							continue;
						dp[row][col] = dp[row][col] < dp[row-1][upCol] + land[row][col] ? dp[row-1][upCol] + land[row][col]
								: dp[row][col];
					}
				}
			}
			Arrays.sort(dp[land.length-1]);.
			return dp[land.length-1][land[0].length - 1];
		}
}
