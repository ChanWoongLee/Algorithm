package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1463 {
	static int[] dp ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);// 최소값 찾기위해 모두 다 크게
		dp[1] = 0;
		for (int i = 1; i < n; i++) { // 바텀업 방식으로 할수있는 방식 횟수 점점쌓아감
			if (i * 3 <= n && dp[i * 3] > dp[i] + 1) // 여기서 중요한게  이전에 있던값이 갱신하려는 값보다 클때만 하는게 중요
				dp[i * 3] = dp[i] + 1;
			if (i * 2 <= n && dp[i * 2] > dp[i] + 1)
				dp[i * 2] = dp[i] + 1;
			if(i + 1 <= n && dp[i+1] > dp[i] +1) 
				dp[i+1] = dp[i] + 1;
		}
		System.out.println(dp[n]);
		
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);// 최소값 찾기위해 모두 다 크게
		dp[n] = 1;
		topdown(n);
	}
	
	static int topdown(int n) {
		return n;
		
	}
}
