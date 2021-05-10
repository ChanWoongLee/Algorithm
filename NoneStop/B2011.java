package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String str = st.nextToken();
		if(str.length() == 1) {
			
		}
		int[] dp = new int[str.length()];
		dp[0] = 1;
		for (int i = 1; i < str.length(); i++) {
			if (i == 1) {
				if ((str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') && str.charAt(i) <= '6') {
					dp[1] = 2;
				} else
					dp[1] = 1;
			} else {
				if ((str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') && str.charAt(i) <= '6') {
					dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
				} else
					dp[i] = dp[i-1];
			}
		}
		System.out.println(dp[str.length()-1]);
	}

}
