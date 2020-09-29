package AcmicpcºÎ¼ø´Ù;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String A = bf.readLine();
		String B = bf.readLine();
		int[][] dp = new int[A.length()][A.length()];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j]++;
				}
			}
		}
	}

}
